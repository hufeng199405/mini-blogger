package com.component.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 类备注：rabbitmq配置
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-10 19:31
 * @desc
 * @since 1.8
 */
@ConfigurationProperties
@PropertySource(value = "classpath:rabbitmq.properties")
public class RabbitmqConfig {

    @Value("${rabbit.host}")
    private String host;

    @Value("${rabbit.username}")
    private String username;

    @Value("${rabbit.password}")
    private String password;

    @Value("${rabbit.port}")
    private Integer port;

    @Value("${rabbit.chanelname}")
    private String chanelname;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getChanelname() {
        return chanelname;
    }

    public void setChanelname(String chanelname) {
        this.chanelname = chanelname;
    }
}
