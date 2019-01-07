package edu.charles.tf.service.impl;

import edu.charles.tf.domain.Customer;
import edu.charles.tf.entity.CustomerEntity;
import edu.charles.tf.mapper.CustomerMapper;
import edu.charles.tf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class CustomerServiceImpl implements UserDetailsService, CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Long addNewCustomer(CustomerEntity entity) {
        entity.setCreateTime(new Date());
        int id = customerMapper.insert(entity);
        return Long.valueOf(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> list = customerMapper.selectByName(username);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else
            throw new UsernameNotFoundException("name : " + username + " is not found!");
    }
}
