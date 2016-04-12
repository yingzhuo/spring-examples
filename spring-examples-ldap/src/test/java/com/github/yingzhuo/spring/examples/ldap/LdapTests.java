package com.github.yingzhuo.spring.examples.ldap;

import com.github.yingzhuo.spring.examples.ldap.dao.UserDao;
import com.github.yingzhuo.spring.examples.ldap.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class LdapTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        User user = userDao.findByUid("yingzhuo");
        System.out.println(user);
    }

}
