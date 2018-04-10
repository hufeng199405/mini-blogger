package com.component.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
}
