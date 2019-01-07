package edu.charles.tf.service;

import edu.charles.tf.domain.UserAgent;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

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

    @Value("${jwt.token.head}")
    private String tokenHead;

    @Autowired
    private CacheService cacheService;

    protected String generateToken(UserDetails userDetails, String name, String tokenHead) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(name, userDetails.getUsername());
        String token = Jwts.builder()
                .setClaims(claims)
                //                .setExpiration(DateUtils.addDays(new Date(), expiredDays))
                .signWith(SignatureAlgorithm.HS512, securityKey) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
        token = null == tokenHead ? token : tokenHead + token;
        //增加缓存
        try {
            cacheService.put(name, token);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return token;
    }

    public String getUserName(String token) {
        token = cutPrefix(token);
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().get("username").toString();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        //TODO:这里需要完善
        String tk = cacheService.get(userDetails.getUsername());
        return tk.equals(token);
    }

    public void removeToken(UserDetails userDetails, UserAgent userAgent) {
        String platformType = getPlatformType(userAgent);
        String key = userDetails.getUsername();
        cacheService.del(key);
    }

    protected String cutPrefix(String token) {
        return token.substring(null == tokenHead ? 0 : tokenHead.length());
    }

    /**
     * 获取请求的平台信息
     *
     * @return
     */
    protected String getPlatformType(UserAgent userAgent) {
        String platformType;
        if (null != userAgent.getPlatformType()) {
            platformType = userAgent.getPlatformType();
        } else
            platformType = null;
        return platformType;
    }
}
