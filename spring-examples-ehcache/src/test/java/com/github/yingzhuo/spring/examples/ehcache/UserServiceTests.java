package com.github.yingzhuo.spring.examples.ehcache;

import com.github.yingzhuo.spring.examples.ehcache.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.findUserById("1");  // 第一次查询
        userService.findUserById("1");
        userService.findUserById("1");

        userService.deleteUserById("1");   // 手动清除缓存
        userService.findUserById("1");      // 再一次查询
        userService.findUserById("1");
    }
}
