package marsv.rabbitmq.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import jdk.nashorn.internal.objects.NativeUint8Array;
import marsv.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Service {

    private static final String QUEUE_NAME = "Work Queue Test";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Connection connection = ConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0 ; i < 50; i ++) {
            String msg = "消息序号："+i;
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            Thread.sleep(i*20);

            System.out.println("正在发送第"+i+"条数据");
        }

        channel.close();
        connection.close();
    }
}
