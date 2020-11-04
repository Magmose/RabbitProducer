package dk.dd.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class RabbitConfig {
    public final static String QUEUE_NAME = "myrabbitqueue";
    public final static String EXCHANGE_NAME = "myrabbitexchange";
    public final static String BINDING_KEY = "camel";

    public static void configConnection(String message) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            channel.exchangeDeclare(EXCHANGE_NAME, "direct",true);

            channel.queueDeclare(QUEUE_NAME,true,false,false,null);

            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,BINDING_KEY);
            channel.basicPublish(EXCHANGE_NAME,BINDING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("UTF-8"));
        }
    }
}
