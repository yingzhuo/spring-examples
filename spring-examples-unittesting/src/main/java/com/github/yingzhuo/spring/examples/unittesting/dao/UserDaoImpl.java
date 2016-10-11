package com.github.yingzhuo.spring.examples.unittesting.dao;

import com.github.yingzhuo.spring.examples.unittesting.domain.User;
import com.github.yingzhuo.spring.examples.unittesting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final UserMapper userMapper;

    @Autowired
    public UserDaoImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

}
