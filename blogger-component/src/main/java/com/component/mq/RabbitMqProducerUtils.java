package com.component.mq;

import com.component.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类备注：rabbitmq队列生产者工具类
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-10 18:45
 * @desc
 * @since 1.8
 */
public class RabbitMqProducerUtils {

    /**
     * @throws Exception
     */
    public static void rabbitMqProducer(String queueName, Object content) throws Exception {

        // 获取一个rabbitmq连接
        Connection connection = RabbitMqFactory.getinstance().createConnectionFactory();

        // 创建一个chanel
        Channel channel = connection.createChannel();

        // 指定一个队列
        channel.queueDeclare(queueName, false, false, false, null);

        // 往队列中发送一条消息
        channel.basicPublish("", queueName, null, content.toString().getBytes());

        // 关闭通道
        channel.close();

        // 关闭连接
        connection.close();
    }
}
