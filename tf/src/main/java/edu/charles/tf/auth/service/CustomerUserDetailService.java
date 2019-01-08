package edu.charles.tf.auth.service;

import edu.charles.tf.domain.Customer;
import edu.charles.tf.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Qualifier("customerUserDetailService")
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> list = customerMapper.selectByAccount(username);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else
            throw new UsernameNotFoundException("account : " + username + " is not found!");
    }
}
