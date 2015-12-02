package com.github.yingzhuo.spring.examples.jpa.dao;

import com.github.yingzhuo.spring.examples.jpa.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, String> {
}