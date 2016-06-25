package com.github.yingzhuo.spring.examples.scheduler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@EnableScheduling
public class ApplicationConfigScheduler {

    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor bean = new ThreadPoolTaskExecutor();
        bean.setCorePoolSize(5);
        bean.setMaxPoolSize(10);
        bean.setQueueCapacity(25);
        return bean;
    }

}
