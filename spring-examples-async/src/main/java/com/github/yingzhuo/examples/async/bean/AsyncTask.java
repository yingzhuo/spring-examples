package com.github.yingzhuo.examples.async.bean;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    @Async
    public void doExecute() throws Throwable {
        Thread.sleep(3000);
        System.out.println("do some async task");
    }

}
