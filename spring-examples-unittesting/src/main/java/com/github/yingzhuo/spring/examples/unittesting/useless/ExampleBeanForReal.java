package com.github.yingzhuo.spring.examples.unittesting.useless;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("real")
public class ExampleBeanForReal implements ExampleBean {

    public ExampleBeanForReal() {
        System.out.println("创建这个bean: " + ExampleBeanForReal.class.getSimpleName());
    }

    @Override
    public void doSomething() {
        System.out.println("hello world.");
        System.out.println("hello world.");
        System.out.println("hello world.");
    }

}
