package edu.charles.tf.service.impl;

import edu.charles.tf.entity.CustomerEntity;
import edu.charles.tf.mapper.CustomerMapper;
import edu.charles.tf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
@Qualifier("customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Long addNewCustomer(CustomerEntity entity) {
        entity.setCreateTime(new Date());
        int id = customerMapper.insert(entity);
        return Long.valueOf(id);
    }

}
