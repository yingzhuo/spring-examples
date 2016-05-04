package com.github.yingzhuo.spring.examples.redis;

import com.github.yingzhuo.spring.examples.redis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private StringRedisTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setName("文晶晶");

        final ValueOperations<String, String> operations = template.opsForValue();
        if (!template.hasKey(user.getId())) {
            operations.set(user.getId(), user.getName());
        }

        System.out.println("Done !!!");
    }

}
