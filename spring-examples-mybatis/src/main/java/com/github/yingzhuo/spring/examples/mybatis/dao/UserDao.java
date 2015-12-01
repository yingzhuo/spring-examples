package com.github.yingzhuo.spring.examples.mybatis.dao;

import com.github.yingzhuo.spring.examples.mybatis.domain.User;

import java.util.List;

public interface UserDao {

    public List<User> findAllUsers();

}
