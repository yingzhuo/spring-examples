package com.github.yingzhuo.spring.examples.es.repo;

import com.github.yingzhuo.spring.examples.es.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepo extends ElasticsearchRepository<User, String> {

    public User findByName(String name);

}
