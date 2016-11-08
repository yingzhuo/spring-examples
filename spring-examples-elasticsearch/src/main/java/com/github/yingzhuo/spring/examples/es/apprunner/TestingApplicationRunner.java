package com.github.yingzhuo.spring.examples.es.apprunner;

import com.github.yingzhuo.spring.examples.es.domain.Gender;
import com.github.yingzhuo.spring.examples.es.domain.User;
import com.github.yingzhuo.spring.examples.es.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final String id = "yingzhuo1234567890";

        User user1 = new User();
        user1.setId(id);
        user1.setName("应卓");
        user1.setGender(Gender.MALE);

        userRepo.save(user1);

        User user2 = userRepo.findByName("应卓");
        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getGender());
    }

}
