package com.github.yingzhuo.spring.examples.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Destination;

@Configuration
public class ApplicationConfigJms {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfigJms.class);

    @Bean(name = "queue.test")
    public Destination testQueue() {
        return new ActiveMQQueue("queue.test");
    }

}
