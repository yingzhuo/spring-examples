package com.github.yingzhuo.examples.async.bean;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTaskImpl implements AsyncTask {

    @Override
    public Future<Integer> doTask() {
        try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
        return new AsyncResult<>(Integer.MAX_VALUE);
    }

}