package edu.charles.tf.service;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import edu.charles.tf.domain.UserAgent;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a1 on 2017/7/19.
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

    public static final String NAME_ACCOUNT = "username";

    protected String generateToken(UserDetails userDetails, String name, String tokenHead,
            int expiredDays, String platformType, String ip) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(name, userDetails.getUsername());
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(DateUtils.addDays(new Date(), expiredDays))
                .signWith(SignatureAlgorithm.HS512, securityKey) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
        token = null == tokenHead ? token : tokenHead + token;
        //增加缓存
        try {
            Map<String, String> value = new HashMap<>();
            value.put("token", token);
            value.put("ip", ip);
            String key = getTokenCacheKey(name, userDetails.getUsername(), platformType);
            cache.hmset(key, value, expiredDays * 24 * 3600);
            //            cache.setex(getTokenCacheKey(name, userDetails.getUsername()), expiredDays * 24 * 3600, token);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        }
        return token;
    }

    public String getUserName(String token) {
        token = cutPrefix(token);
        return Jwts.parser().setSigningKey(securityKey).parseClaimsJws(token).getBody().get("username").toString();
    }

    public boolean validateToken(String token, UserDetails userDetails, UserAgent userAgent) {
        //TODO:这里需要完善
        String reqIp = userAgent.getIp();
        String platformType = getPlatformType(userAgent);
        String key = getTokenCacheKey(NAME_ACCOUNT, userDetails.getUsername(), platformType);
        if (cache.exists(key)) {
            List<String> values = cache.hmget(key, "token", "ip");
            String trueIp = values.get(1);
            String trueToken = values.get(0);
            if (trueIp.equals(reqIp) && trueToken.equals(token)) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

    public void removeToken(UserDetails userDetails, UserAgent userAgent) {
        String platformType = getPlatformType(userAgent);
        String key = getTokenCacheKey(NAME_ACCOUNT, userDetails.getUsername(), platformType);
        long result = cache.del(key);
        if (0 == result) {
            log.error("Invalid key:" + key + ", " + "could not be deleted!");
        }
        if (log.isDebugEnabled()) {
            log.debug("delete key :" + key);
        }
    }

    protected String cutPrefix(String token) {
        return token.substring(null == tokenHead ? 0 : tokenHead.length());
    }

    private String getTokenCacheKey(String name, String value) {
        return name + "_" + value + "_token";
    }

    private String getTokenCacheKey(String name, String value, String platformType) {
        return name + "_" + platformType + "_" + value + "_token";
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
