package edu.charles.tf.controller;

import edu.charles.tf.entity.CustomerEntity;
import edu.charles.tf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/custom")
public class CustomerController extends AbstractBaseController{
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Map<String, Object> addCustomer(@ModelAttribute CustomerEntity customerEntity) {
        Map<String, Object> result = null;
        try {
            Long id = customerService.addNewCustomer(customerEntity);
            result.put("id", id);
        } catch (Exception e) {
            result.put("err", 500);
            log.error(e.getMessage(),e);
        }
        return result;
    }
}
