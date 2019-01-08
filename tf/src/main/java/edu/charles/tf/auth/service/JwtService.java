package edu.charles.tf.auth.service;

import edu.charles.tf.service.CacheService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: CharlesZheng
 * @Date 20:15 2019/1/7
 */
@Service
public class JwtService {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Value("${security.key}")
    private String securityKey;

    @Autowired
    private CacheService cacheService;
    @Value("${jwt.customer.customToken.head}")
    private String customerTokenHead;
    //用户token失效时间
    private static final int customerTokenExpiredDays = 1;
    private static final String  ACCOUNT = "account";
    /**
     * 生成用户token
     *
     * @auther: CharlesZheng
     * @Date 15:11 2019/1/8
     */
    public String generateCustomerToken(UserDetails userDetails, String account) {
        return generateToken(userDetails, ACCOUNT, customerTokenHead, customerTokenExpiredDays);
    }

    protected String generateToken(UserDetails userDetails, String name, String tokenHead, int expiredDays) {
        Map<String, Object> claims = new HashMap<>();
        String username=userDetails.getUsername();
        claims.put(name, username);
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(DateUtils.addDays(new Date(), expiredDays))
                .signWith(SignatureAlgorithm.HS512, securityKey) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
        token = null == tokenHead ? token : tokenHead + token;
        //增加缓存
        try {
            cacheService.put(username, token);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return token;
    }

    public String getCustomerAccount(String token) {
        token = cutCustomPrefix(token);
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().get(ACCOUNT).toString();
    }

    /**
     * 校验token
     *
     * @auther: CharlesZheng
     * @Date 16:08 2019/1/8
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        //TODO:这里需要完善
        String tk = cacheService.get(userDetails.getUsername());
        return token.equals(tk);
    }

    public void removeToken(UserDetails userDetails) {
        String key = userDetails.getUsername();
        cacheService.del(key);
    }

    protected String cutCustomPrefix(String token) {
        return token.substring(null == customerTokenHead ? 0 : customerTokenHead.length());
    }
}
