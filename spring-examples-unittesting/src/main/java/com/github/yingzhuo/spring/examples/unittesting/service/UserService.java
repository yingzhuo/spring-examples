package com.github.yingzhuo.spring.examples.unittesting.service;

import com.github.yingzhuo.spring.examples.unittesting.domain.User;

public interface UserService {

    public User findUserById(String userId);

    public User complexMethod();

}
