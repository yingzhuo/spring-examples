package com.github.yingzhuo.spring.examples.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SomeTask {

    @Scheduled(cron = "0 0 0/12 * * ?")
    public void execute() {

    }


}
