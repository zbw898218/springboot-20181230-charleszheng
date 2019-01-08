package edu.charles.tf;

import edu.charles.tf.filter.JwtAuthenticationTokenFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@MapperScan({ "edu.charles.tf.mapper" })
public class TengfApplication {

    public static void main(String[] args) {
        SpringApplication.run(TengfApplication.class, args);
    }

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        // Spring会自动寻找同样类型的具体类注入，这里就是JwtUserDetailsServiceImpl了
        @Autowired
        @Qualifier("customerUserDetailService")
        private UserDetailsService customerUserDetailService;

        @Value("${jwt.customer.customToken.head}")
        private String customerTokenHead;

        @Autowired
        @Qualifier("customerAuthenticationProvider")
        private AuthenticationProvider customerProvider;

        @Autowired
        public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) {
            authenticationManagerBuilder
                    .authenticationProvider(customerProvider);
        }

        @Bean
        public JwtAuthenticationTokenFilter authenticationTokenFilterBean() {
            JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
            filter.setUserDetailsService(customerUserDetailService);
            filter.setTokenHead(customerTokenHead);
            return filter;
        }

        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    // 由于使用的是JWT，我们这里不需要csrf
                    .csrf().disable()

                    // 基于token，所以不需要session
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                    .authorizeRequests()

                    .antMatchers("/auth/**").permitAll()
                    // 除上面外的所有请求全部需要鉴权认证
                    .anyRequest().authenticated().and()
                    .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

            // 禁用缓存
            httpSecurity.headers().cacheControl();
        }
    }

    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

