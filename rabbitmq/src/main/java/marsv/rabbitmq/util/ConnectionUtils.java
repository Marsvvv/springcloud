package marsv.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    /**
     * 获取RabbitMQ链接
     * @return
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        //  创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/vhost_marsv");
        connectionFactory.setUsername("marsv");
        connectionFactory.setPassword("marsv");

        Connection connection = connectionFactory.newConnection();
        return connection;
    }
}
