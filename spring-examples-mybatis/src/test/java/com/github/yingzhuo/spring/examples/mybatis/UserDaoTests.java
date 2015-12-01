package com.github.yingzhuo.spring.examples.mybatis;

import com.github.yingzhuo.spring.examples.mybatis.dao.UserDao;
import com.github.yingzhuo.spring.examples.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class UserDaoTests {

    @Autowired
    UserDao userDao;

    @Test
    public void test1() {
        List<User> list = userDao.findAllUsers();
        list.forEach(System.out::println);
    }
}
