package com.github.yingzhuo.spring.examples.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication
public class ApplicationBoot {

    private ApplicationEventPublisher publisher;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

}
