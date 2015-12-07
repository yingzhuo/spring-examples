package com.github.yingzhuo.spring.examples.email;

import com.github.yingzhuo.spring.examples.email.tool.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class MailServiceTests {

    @Autowired
    private MailService mailService;

    @Test
    public void test1() {
        mailService.sendMimeMessage("yingzhor@163.com", "测试邮件", "<h1>测试邮件正文<h1>");
    }
}
