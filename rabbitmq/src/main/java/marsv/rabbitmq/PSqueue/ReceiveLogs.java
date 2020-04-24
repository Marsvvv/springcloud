package marsv.rabbitmq.PSqueue;

import com.rabbitmq.client.*;
import marsv.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ReceiveLogs {

//    private static final String QUEUE_NAME = "Publish/Subscribe Queue";

    private static final String EXCHANGE_NAME = "Publish/Subscribe Exchange";

    public static void main(String[] args) throws IOException, TimeoutException {
        //  创建链接
        Connection connection = ConnectionUtils.getConnection();
        //  创建通道
        Channel channel = connection.createChannel();
        //  声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        //  根据交换机获得队列名
        String queueName = channel.queueDeclare().getQueue();
        //  绑定交换机和队列名
        channel.exchangeBind(queueName, EXCHANGE_NAME, "");
        //  创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("消费者1："+msg);
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
