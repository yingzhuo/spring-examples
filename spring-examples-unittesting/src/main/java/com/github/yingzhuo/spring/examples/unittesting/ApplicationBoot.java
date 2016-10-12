package com.github.yingzhuo.spring.examples.unittesting;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ImportResource(locations = {"classpath*:spring-*.xml"})
public class ApplicationBoot implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args).close();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SpringUtils.getProfiles().forEach(System.out::println);
    }

}
