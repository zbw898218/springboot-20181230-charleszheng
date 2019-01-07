/**
 * Copyright (C), 2002-2018, 苏宁易购电子商务有限公司
 * FileName: BaseCacheService.java
 * Author:   Zhengbiwu(18061259)
 * Date:     2019/1/7 17:25
 * Description: 模块目的、功能描述
 * History:
 * &lt;author&gt;      &lt;time&gt;      &lt;version&gt;    &lt;desc&gt;
 * 修改人姓名             修改时间            版本号                  描述
 */
package edu.charles.tf.service.impl;

import edu.charles.tf.base.util.WorkThread;
import edu.charles.tf.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    private static Map<String,String> cacheToken=new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        logger.info("BaseCacheService init start...");
        load();
        this.start("BaseCacheService");
        logger.info("BaseCacheService init end.");
    }


    @Override
    public void work() throws Exception {

    }


    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String put(String key, String value) {
        return null;
    }
}
