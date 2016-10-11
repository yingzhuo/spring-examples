package com.github.yingzhuo.spring.examples.unittesting.dao;

import com.github.yingzhuo.spring.examples.unittesting.domain.User;

public interface UserDao {

    public User findById(String id);

}
