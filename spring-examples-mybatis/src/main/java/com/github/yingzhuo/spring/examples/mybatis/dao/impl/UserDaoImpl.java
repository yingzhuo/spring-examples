package com.github.yingzhuo.spring.examples.mybatis.dao.impl;

import com.github.yingzhuo.spring.examples.mybatis.dao.UserDao;
import com.github.yingzhuo.spring.examples.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    public List<User> findAllUsers() {
        return sqlSession.selectList("user.findAllUsers");
    }

}
