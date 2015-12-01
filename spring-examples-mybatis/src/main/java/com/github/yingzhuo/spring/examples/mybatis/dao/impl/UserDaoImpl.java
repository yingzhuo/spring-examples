package com.github.yingzhuo.spring.examples.mybatis.dao.impl;

import com.github.yingzhuo.spring.examples.mybatis.dao.UserDao;
import com.github.yingzhuo.spring.examples.mybatis.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<User> findAllUsers() {
        return sqlSession.selectList("user.findAllUsers");
    }
}
