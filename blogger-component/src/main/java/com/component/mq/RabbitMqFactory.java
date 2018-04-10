package com.component.mq;

import com.component.config.RabbitmqConfig;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类备注：rabbitmq连接工厂
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-10 19:00
 * @desc
 * @since 1.8
 */
public class RabbitMqFactory {

    @Autowired
    private RabbitmqConfig rabbitmqConfig;

    public static RabbitMqFactory getinstance() throws Exception {

        return RabbitMqHolder.rabbitMqFactory;
    }

    public Connection createConnectionFactory() throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        // host
        connectionFactory.setHost(rabbitmqConfig.getHost());

        // 用户名
        connectionFactory.setUsername(rabbitmqConfig.getUsername());

        // 密码
        connectionFactory.setPassword(rabbitmqConfig.getPassword());

        // 端口
        connectionFactory.setPort(rabbitmqConfig.getPort());

        Connection connection = connectionFactory.newConnection();

        return connection;
    }

    // 使用内部类创建单例
    static class RabbitMqHolder {

        private static RabbitMqFactory rabbitMqFactory = new RabbitMqFactory();
    }
}
