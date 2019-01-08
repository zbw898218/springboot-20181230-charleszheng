package edu.charles.tf.mvc.controller;

import edu.charles.tf.base.mvc.controller.AbstractBaseController;
import edu.charles.tf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/custom")
public class CustomerController extends AbstractBaseController {
    @Autowired
    private CustomerService customerService;
}
