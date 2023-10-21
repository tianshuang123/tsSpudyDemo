package com.ts.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @title FirstProducer
 * @date 2023/10/21 22:54
 * @author ts happy boy
 * @description TODO
 */

public class FirstProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        /*
        * 1、创建Connection
2、创建Channel
3、声明exchange(如果需要的话)
4、声明Queue
5，发送消息，可以发到Exchange，也可以发到Queue。*/
        ConnectionFactory connection = new ConnectionFactory();
        connection.setHost("192.168.228.130");
        connection.setUsername("guest");
        connection.setPassword("guest");
        connection.setVirtualHost("/");
        connection.setPort(5672);
        Connection connection1  = connection.newConnection();
        Channel channel= connection1.createChannel();
        channel.queueDeclare("test2",true,false,false,null);
        String msg = "nihao";
        channel.basicPublish("","test2", MessageProperties.PERSISTENT_TEXT_PLAIN,msg.getBytes());
        channel.close();
        connection1.close();
    }
}



