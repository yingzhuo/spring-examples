package com.github.yingzhuo.spring.examples.ehcache.service;

import com.github.yingzhuo.spring.examples.ehcache.domain.User;

public interface UserService {

    public User findUserById(String id);

    public void deleteUserById(String id);
}
