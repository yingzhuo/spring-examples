package com.github.yingzhuo.spring.examples.es.repo;

import com.github.yingzhuo.spring.examples.es.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {

    public User findByName(String name);

}
