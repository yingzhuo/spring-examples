package com.github.yingzhuo.examples.async.bean;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.Future;

@FunctionalInterface
public interface AsyncTask {

    @Async
    public Future<Integer> doTask();

}
