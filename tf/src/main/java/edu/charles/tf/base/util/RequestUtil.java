package edu.charles.tf.base.util;

import edu.charles.tf.domain.UserAgent;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhengbiwu on 2017/11/15 13:33
 */
public class RequestUtil {
    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * <p>
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     * <p>
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     * <p>
     * 用户真实IP为： 192.168.1.110
     */

    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 用途：根据客户端 User Agent Strings 判断其浏览器、操作平台
     * if 判断的先后次序：
     * 根据设备的用户使用量降序排列，这样对于大多数用户来说可以少判断几次即可拿到结果：
     * >>操作系统:Windows > 苹果 > 安卓 > Linux > ...
     * >>Browser:Chrome > FF > IE > ...
     * <p>
     * ps:为简化，将ip也封装到UserAgent对象中，作为一个属性
     *
     * @return
     */
    public static UserAgent getUserAgent(HttpServletRequest request) {
        //请求的ip
        String ip = getIpAddress(request);
        String userAgent = request.getHeader("User-Agent");
        UserAgent ua = new UserAgent();
        ua.setIp(ip);
        if (StringUtils.isBlank(userAgent)) {
            //如果拿不到 User-Agent 头信息，就返回一个只有ip的对象
            return ua;
        }
        if (userAgent.contains("Windows")) {//主流应用靠前
            ua.setPlatformType("Windows");
        } else if (userAgent.contains("Mac OS X")) {
            ua.setPlatformType("Mac OS X");
        } else if (userAgent.contains("Android")) {
            ua.setPlatformType("Android");
        } else if (userAgent.contains("PostmanRuntime")) {//做测试用
            ua.setPlatformType("Postman");
        } else {
            //没获得到请求的操作平台，直接返回
            return ua;
        }
        return judgeBrowser(userAgent, ua);
    }

    /**
     * 用途：根据客户端 User Agent Strings 判断其浏览器
     * if 判断的先后次序：
     * 根据浏览器的用户使用量降序排列，这样对于大多数用户来说可以少判断几次即可拿到结果：
     * >>Browser:Chrome > FF > IE > ...
     *
     * @param userAgent:user agent
     * @return
     */
    private static UserAgent judgeBrowser(String userAgent, UserAgent ua) {
        if (userAgent.contains("Chrome")) {
            ua.setBrowserType("Chrome");
        } else if (userAgent.contains("Firefox")) {
            ua.setBrowserType("Firefox");
        } else if (userAgent.contains("MSIE")) {
            ua.setBrowserType("Internet Explorer(MSIE)");
        } else if (userAgent.contains("Trident")) {
            ua.setBrowserType("Internet Explorer(Trident)");
        } else {//TODO:其它浏览器,后续补充
            ua.setBrowserType(null);
        }
        return ua;
    }
}
