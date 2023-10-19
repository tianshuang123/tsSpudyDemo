package com.ts;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        rabbitTemplate.convertAndSend(queName,msg);
    }

    @org.junit.jupiter.api.Test
    void testSendMsg1() throws InterruptedException {
        String queName = "work.queue";
        for (int i = 0; i < 50; i++) {
            String msg = "hello ,ts amqp!！！！"+i;
            rabbitTemplate.convertAndSend(queName,msg);
            Thread.sleep(20);
        }
    }

}



