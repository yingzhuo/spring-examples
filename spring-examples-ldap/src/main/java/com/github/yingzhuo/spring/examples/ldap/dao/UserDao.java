package com.github.yingzhuo.spring.examples.ldap.dao;

import com.github.yingzhuo.spring.examples.ldap.domain.User;

public interface UserDao {

    public User findByUid(String uid);

}
