package com.github.yingzhuo.spring.examples.mybatis;

import com.github.yingzhuo.spring.examples.mybatis.domain.User;
import com.github.yingzhuo.spring.examples.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args).close();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userMapper != null) {
            User user = userMapper.findById("1");
            System.out.println(user);
        }
    }

}
