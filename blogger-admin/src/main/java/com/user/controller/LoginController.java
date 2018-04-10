package com.user.controller;

import com.component.mq.RabbitMqProducerUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-10 22:02
 * @desc
 * @since 1.8
 */

public class LoginController {

    @Test
    public void aa() throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        // host
        connectionFactory.setHost("47.93.243.203");

        // 用户名
        connectionFactory.setUsername("test");

        // 密码
        connectionFactory.setPassword("test");

        // 端口
        connectionFactory.setPort(AMQP.PROTOCOL.PORT);

        Connection connection = connectionFactory.newConnection();

        // 创建一个chanel
        Channel channel = connection.createChannel();

        // 指定一个队列
        channel.queueDeclare("test", false, false, false, null);

        // 往队列中发送一条消息
        channel.basicPublish("", "test", null, "this is test".getBytes());

        // 关闭通道
        channel.close();

        // 关闭连接
        connection.close();
    }
}
