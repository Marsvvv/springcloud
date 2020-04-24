package marsv.rabbitmq.PSqueue;

import com.rabbitmq.client.*;
import marsv.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogs2 {

    private static final String QUEUE_NAME = "Publish/Subscribe Queue";

    private static final String EXCHANGE_NAME = "Publish/Subscribe Exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建链接
        Connection connection = ConnectionUtils.getConnection();
        //  创建通道
        Channel channel = connection.createChannel();
        //  声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //  绑定到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("消费者2："+msg);
            }
        };
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }
}
