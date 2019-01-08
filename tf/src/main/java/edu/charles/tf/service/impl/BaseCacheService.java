package edu.charles.tf.service.impl;

import edu.charles.tf.base.util.WorkThread;
import edu.charles.tf.domain.CustomToken;
import edu.charles.tf.domain.Customer;
import edu.charles.tf.mapper.CustomTokenMapper;
import edu.charles.tf.mapper.CustomerMapper;
import edu.charles.tf.service.CacheService;
import edu.charles.tf.service.CustomerTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service("baseCacheService")
public class BaseCacheService extends WorkThread implements CacheService {
    private static Map<String, CustomToken> cacheToken = new ConcurrentHashMap<>();

    @Autowired
    private CustomTokenMapper customTokenMapper;
    @Autowired
    private CustomerTokenService customerTokenService;
    @Autowired
    private CustomerMapper customerMapper;

    @Value("${customToken.expire.time}")
    private long tokenExpireTime;
    //10分钟刷新一次
    private static final long default_refresh_time = 10 * 60000l;

    @PostConstruct
    public void init() {
        logger.info("BaseCacheService init start...");
        load();
        this.start("BaseCacheService");
        logger.info("BaseCacheService init end.");
    }

    @Override
    public void work() throws Exception {
        while (super.isWork()) {
            // 休眠10min
            sleep(default_refresh_time);
            load();
        }
    }

    private void load() {
        List<CustomToken> customTokens = customTokenMapper.selectAll();
        if (null != customTokens && !customTokens.isEmpty()) {
            for (CustomToken customToken : customTokens) {
                Customer customer = customerMapper.selectById(customToken.getCustomer().getId());
                cacheToken.put(customer.getAccount(), customToken);
            }
        }
    }

    @Override
    public String get(String key) {
        CustomToken customToken;
        if (cacheToken.containsKey(key)) {
            customToken = cacheToken.get(key);
            return customToken.getToken();
        } else {
            List<Customer> list = customerMapper.selectByAccount(key);
            if (null == list || list.isEmpty()) {
                return null;
            }
            Customer customer = list.get(0);
            customToken = customTokenMapper.selectByCustomerId(customer.getId());
            return customToken.getToken();
        }
    }

    @Override
    public void put(String key, String token) {
        CustomToken customToken = new CustomToken();
        Customer customer = customerMapper.selectByAccount(key).get(0);
        customToken.setCustomer(customer);
        customToken.setCreateTime(new Date());
        customToken.setUpdateTime(new Date());
        customToken.setToken(token);
        customerTokenService.updateToken(key, customToken);
        cacheToken.put(key, customToken);
    }

    @Override
    public void del(String key) {
        cacheToken.remove(key);
        customerTokenService.del(key);
    }
}
