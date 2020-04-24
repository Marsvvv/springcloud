package marsv.rabbitmq.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import marsv.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Client {

    private static final String QUEUE_NAME = "Simple_Queue";

    public static void main(String[] args) throws IOException, TimeoutException {
//        创建连接
        Connection connection = ConnectionUtils.getConnection();

//        创建通道
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String msg = "It is RabbitMQ Simple Queue Test 2020 2 20";

        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

        channel.close();
        connection.close();
    }
}
