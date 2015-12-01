package com.github.yingzhuo.spring.examples.retry.service;

import org.springframework.retry.annotation.Retryable;

public interface NumberService {

    @Retryable(maxAttempts = 3)
    public Integer getRandomOddInteger();

}
