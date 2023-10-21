package com.ts.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @title MqListren
 * @date 2023/10/19 22:14
 * @author ts happy boy
 * @description TODO
 */

@Component
public class MqListren {
//    @RabbitListener(queues = "hello.ts")
//    public void listenSimpleQueue(String msg){
//        System.out.println("收到消息》》》"+msg);
//    }


    @RabbitListener(queues = "work.queue")
    public void listenSimpleQueue1(String msg) throws InterruptedException {
        Thread.sleep(1000*2);
        System.out.println("listenSimpleQueue1收到消息》》》"+msg);
    }


    @RabbitListener(queues = "work.queue")
    public void listenSimpleQueue2(String msg) throws InterruptedException {
        Thread.sleep(1000*1);
        System.err.println("listenSimpleQueue2收到消息》》》"+msg);
    }


    @RabbitListener(queues = "json.test")
    public void listenSimpleQueue3(Map msg) throws InterruptedException {
        Thread.sleep(1000*1);
        System.err.println("JsonTest收到消息》》》"+msg);
    }


}



