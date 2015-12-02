package com.github.yingzhuo.spring.examples.jpa;

import com.github.yingzhuo.spring.examples.jpa.dao.UserDao;
import com.github.yingzhuo.spring.examples.jpa.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class UserDaoTests {

    @Autowired
    UserDao userDao;

    @Test
    public void test1() {
        Iterable<User> users =  userDao.findAll();
        users.forEach(System.out::println);
    }

}
