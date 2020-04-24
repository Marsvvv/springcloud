package marsv.rabbitmq.simplequeue;

import com.rabbitmq.client.*;
import marsv.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Service {

    private static final String QUEUE_NAME = "Simple_Queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf-8");
                System.out.println(msg);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }

    private void oldApi() throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        channel.basicConsume(QUEUE_NAME, true, queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println(new Date()+":"+msg);
        }
    }
}
