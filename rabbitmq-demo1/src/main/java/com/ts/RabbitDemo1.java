package com.ts;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author ts happy boy
 * @title ${NAME}
 * @date ${DATE} ${TIME}
 * @description TODO
 */
@SpringBootApplication
public class RabbitDemo1 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitDemo1.class);
    }
    @Bean
    public MessageConverter jacksonConvertor(){
        return new Jackson2JsonMessageConverter();
    }
}