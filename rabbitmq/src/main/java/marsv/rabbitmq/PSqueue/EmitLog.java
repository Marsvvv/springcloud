package marsv.rabbitmq.PSqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import marsv.rabbitmq.util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class EmitLog {

    private static final String EXCHANGE_NAME = "Publish/Subscribe Exchange";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        for (int i = 0 ; i < 50; i ++) {
            String msg = "消息序号："+i;
            channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());
            Thread.sleep(500);

            System.out.println("正在发送第"+i+"条数据");
        }
        channel.close();
        connection.close();
    }
}
