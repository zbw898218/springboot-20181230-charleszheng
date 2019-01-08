package edu.charles.tf.auth.controller;

import edu.charles.tf.auth.service.AuthService;
import edu.charles.tf.base.mvc.controller.AbstractBaseController;
import edu.charles.tf.base.util.RequestUtil;
import edu.charles.tf.domain.Customer;
import edu.charles.tf.domain.UserAgent;
import edu.charles.tf.service.CustomerService;
import edu.charles.tf.vo.WResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/auth")
public class LoginController extends AbstractBaseController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public WResult login(@RequestParam String account, @RequestParam String password) {
        WResult wResult = authService.login(account, password);
        return wResult;
    }

    @RequestMapping("/logout")
    public WResult logout(HttpServletRequest request) throws Exception {
        UserAgent userAgent = RequestUtil.getUserAgent(request);
        Customer customer = super.getCurrentCustomer();
        return authService.logout(customer, userAgent);
    }

    @PostMapping("/register")
    public WResult register(@ModelAttribute Customer customer) throws Exception {
        return authService.register(customer);
    }
}
