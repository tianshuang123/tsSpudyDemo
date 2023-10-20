package com.ts.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title FanoutConfigration
 * @date 2023/10/19 23:13
 * @author ts happy boy
 * @description TODO
 */

@Configuration
public class FanoutConfigration {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("ts.fanout2");
    }


    @Bean
    public Queue fanoutQueue3(){
//        QueueBuilder.durable().build();
        return new Queue("fanout.queue3");
    }

    @Bean
    public Binding fanoutBinding(){
        return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange());
    }
}



