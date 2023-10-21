package com.ts;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @title Test
 * @date 2023/10/19 21:50
 * @author ts happy boy
 * @description TODO
 */

@SpringBootTest
public class Test {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @org.junit.jupiter.api.Test
    void testSendMsg(){
        String queName = "hello.ts";
        String msg = "hello ,ts amqp!";
        System.out.println();
        rabbitTemplate.convertAndSend(queName,msg);
    }

    @org.junit.jupiter.api.Test
    void testSendMsg1() throws InterruptedException {
        String queName = "work.queue";
        for (int i = 0; i < 50; i++) {
            String msg = "hello ,ts amqp!！！！"+i;
            rabbitTemplate.convertAndSend(queName,msg);
        }
    }

    @org.junit.jupiter.api.Test
    void testSendMsgJson(){
        String queName = "json.test";
        String msg = "hello ,ts amqp!";
        Map map = new HashMap();
        map.put(queName,msg);
        rabbitTemplate.convertAndSend(queName,map);
    }

    @org.junit.jupiter.api.Test
    void test(){
        Message message = MessageBuilder.withBody("hello".getBytes(StandardCharsets.UTF_8))
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        for (int i = 0; i < 1000000; i++) {
            rabbitTemplate.convertAndSend("hello.ts",message);
        }
    }



}



