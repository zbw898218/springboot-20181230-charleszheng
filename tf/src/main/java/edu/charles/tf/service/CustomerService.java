package edu.charles.tf.service;

import edu.charles.tf.entity.CustomerEntity;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CustomerService {
    /**
     * 新增用户
     *
     * @auther: CharlesZheng
     * @Date 11:02 2019/1/7
     */
    Long addNewCustomer(CustomerEntity entity);
}
