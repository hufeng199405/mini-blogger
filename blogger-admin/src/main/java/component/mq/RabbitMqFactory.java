package component.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import component.config.RabbitmqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 类备注：rabbitmq连接工厂
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-10 19:00
 * @desc
 * @since 1.8
 */
@Configuration
public class RabbitMqFactory {

    @Autowired
    private RabbitmqConfig rabbitmqConfig;

    public Connection createConnectionFactory() throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        // host
        connectionFactory.setHost(rabbitmqConfig.getHost());

        // 用户名
        connectionFactory.setUsername(rabbitmqConfig.getName());

        // 密码
        connectionFactory.setPassword(rabbitmqConfig.getPassword());

        // 端口
        connectionFactory.setPort(rabbitmqConfig.getPort());

        Connection connection = connectionFactory.newConnection();

        return connection;
    }
}
