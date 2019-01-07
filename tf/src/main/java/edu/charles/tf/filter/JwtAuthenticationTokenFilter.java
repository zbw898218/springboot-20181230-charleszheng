package edu.charles.tf.filter;

import edu.charles.tf.base.util.RequestUtil;
import edu.charles.tf.domain.UserAgent;
import edu.charles.tf.service.JwtService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * （功能简述）
 *
 * @Auther: ZhengBiWu
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.token.head}")
    private String securityKey;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        UserAgent userAgent = RequestUtil.getUserAgent(request);
        String authToken = request.getHeader(this.tokenHeader);
        if (StringUtils.isNoneBlank(authToken)) {
            String username = null;
            try {
                username = jwtService.getUserName(authToken);
            } catch (Exception e) {
                logger.error("jwt auToken: " + authToken + " is error!", e);
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

                if (jwtService.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                            request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
