package edu.charles.tf.auth.service;

import edu.charles.tf.base.service.BaseService;
import edu.charles.tf.base.util.WResultTools;
import edu.charles.tf.domain.Customer;
import edu.charles.tf.domain.UserAgent;
import edu.charles.tf.entity.CustomerEntity;
import edu.charles.tf.enums.PhaseEnum;
import edu.charles.tf.enums.TypeEnum;
import edu.charles.tf.mapper.CustomerMapper;
import edu.charles.tf.mapper.CustomTokenMapper;
import edu.charles.tf.vo.ErrCodeConstants;
import edu.charles.tf.vo.WResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class AuthService extends BaseService {
    @Autowired
    private CustomTokenMapper customTokenMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    @Qualifier("customerUserDetailService")
    private UserDetailsService customerUserDetailService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public WResult login(String account, String password) {
        List<Customer> list = customerMapper.selectByAccount(account);
        if (null == list || list.isEmpty()) {
            return WResultTools.getWResult(false, null, "账号不存在");
        }
        Customer customer = list.get(0);
        String encPass = customer.getPassword();
        if (validatePassword(password, encPass)) {
            String customerToken = jwtService.generateCustomerToken(customer, account);
            return WResultTools.getWResult(true, customerToken, null);
        } else {
            return WResultTools.getWResult(false, "密码错误", ErrCodeConstants.PASSWORD_ERROR);
        }
    }

    public WResult logout(Customer customer, UserAgent userAgent) {
        return null;
    }

    public WResult register(Customer customer) {
        String account = customer.getAccount();
        List<Customer> list = customerMapper.selectByAccount(account);
        if (null == list || list.isEmpty()) {
            String password = customer.getPassword();
            if (null == password || password.equals("")) {
                return WResultTools.getWResult(false, "密码错误", ErrCodeConstants.PASSWORD_ERROR);
            }
            String encPass = passwordEncoder.encode(password);
            CustomerEntity entity = new CustomerEntity();
            BeanUtils.copyProperties(customer, entity);
            entity.setUpdateTime(new Date());
            entity.setCreateTime(new Date());
            entity.setPhase(PhaseEnum.ENABLED);
            entity.setType(TypeEnum.NORMAL);
            entity.setPassword(encPass);
            customerMapper.insert(entity);
            final UserDetails userDetails = customerUserDetailService.loadUserByUsername(account);
            String token = jwtService.generateCustomerToken(userDetails, account);
            return WResultTools.getWResult(true, token, null, ErrCodeConstants.SUCCESS);
        } else {
            return WResultTools.getWResult(false, "账号重复", ErrCodeConstants.ACCOUNT_ERROR);
        }
    }

    /**
     * 更新token信息
     *
     * @auther: CharlesZheng
     * @Date 15:23 2019/1/8
     */
    private void updateToken(Long customerId, String token) {

    }

    protected boolean validatePassword(String rawPass, String encPass) {
        return passwordEncoder.matches(rawPass, encPass);
    }
}
