package edu.charles.tf.auth.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public abstract class CommonAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: 权限错误！");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "密码错误！"));
        }
        if (authentication.getPrincipal() == null) {
            logger.debug("Authentication failed: 账号错误！");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "账号错误！"));
        }

        String presentedUsername = authentication.getPrincipal().toString();
        String presentedPassword = authentication.getCredentials().toString();
        String username = userDetails.getUsername();
        String password = userDetails.getPassword();
        if (username.equals(presentedUsername) && isPasswordValid(presentedPassword, password)) {
            return;
        } else {
            throw new BadCredentialsException("用户名或密码错误！");
        }
    }

    protected boolean isPasswordValid(String rawPass, String encPass) {
        return passwordEncoder.matches(rawPass, encPass);
    }
}