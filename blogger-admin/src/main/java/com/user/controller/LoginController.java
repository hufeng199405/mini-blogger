package com.user.controller;

import com.rabbitmq.client.*;
import com.rabbitmq.client.Channel;
import com.user.service.UserService;
import component.ApplicationFactory;
import component.config.RabbitmqConfig;
import component.mq.RabbitMqFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-10 22:02
 * @desc
 * @since 1.8
 */

@Controller
@RequestMapping("/loginController")
public class LoginController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private RabbitMqFactory rabbitMqFactory;

    @Autowired
    private UserService userService;

    @RequestMapping("/aa")
    public void aa() throws Exception {

        RabbitmqConfig rabbitmqConfig = (RabbitmqConfig) ApplicationFactory.getBean("rabbitmqConfig");

        Connection connection = rabbitMqFactory.createConnectionFactory();

        // 创建一个chanel
        Channel channel = connection.createChannel();

        // 指定一个队列
        channel.queueDeclare("/", false, false, false, null);

        // 往队列中发送一条消息
        channel.basicPublish("", "/", null, "this is test".getBytes());

        // 关闭通道
        channel.close();

        // 关闭连接
        connection.close();
    }

    @Test
    public void bb() throws Exception {

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
        final Channel channel = connection.createChannel();

        // 指定一个队列
        channel.queueDeclare("test", false, false, false, null);

        /*// 创建消费者队列
        channel.basicConsume("test", false, "",
                new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                        String routingKey = envelope.getRoutingKey();
                        String contentType = properties.getContentType();
                        long deliveryTag = envelope.getDeliveryTag();
                        channel.basicAck(deliveryTag, false);
                        System.out.println(body);
                    }
                });*/
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        // 指定消费者队列
        channel.basicConsume("test", true, queueingConsumer);

        QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery(1000);

        String ss = new String(delivery.getBody());

        System.out.println(ss);

        //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);

        // 关闭通道
        channel.close();

        // 关闭连接
        connection.close();
    }

   /* @RequestMapping("/httpPost")
    public void httpPost(HttpServletResponse response) throws Exception {

        byte[] bytes = HttpUtils.post("https://www.baidu.com");

        logger.info(new String(bytes, "UTF-8"));

        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=utf-8");

        response.setStatus(HttpStatus.SC_OK);

        response.getOutputStream().print(new String(bytes, "UTF-8"));

        response.getOutputStream().flush();

        response.getOutputStream().close();
    }*/

    // 登录方法
    @RequestMapping("/login")
    public String login() throws Exception {


        return "";
    }
}
