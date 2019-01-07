package edu.charles.tf.domain;

/**
 * @auther: CharlesZheng
 * @Date 17:12 2019/1/7
 */
public class UserAgent {
    private String ip;//请求ip
    private String browserType;//浏览器类型
    private String platformType;//平台类型

    public String getBrowserType() {
        return browserType;
    }

    public UserAgent() {
    }

    public UserAgent(String platformType, String ip) {
        this.ip = ip;
        this.platformType = platformType;
    }

    public UserAgent(String ip) {
        this.ip = ip;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public UserAgent(String browserType, String platformType, String ip) {
        this.ip = ip;
        this.browserType = browserType;
        this.platformType = platformType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }
}
