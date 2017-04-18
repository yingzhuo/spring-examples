package com.github.yingzhuo.spring.examples.email;

import com.github.yingzhuo.spring.examples.email.tool.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ApplicationBoot {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args).close();
    }

    @EventListener(classes = {ContextRefreshedEvent.class})
    protected void handleEvent() {
        mailService.sendMimeMessage("yingzhor@163.com", "hello", "<h2>测试一下</h2>");
    }

}
