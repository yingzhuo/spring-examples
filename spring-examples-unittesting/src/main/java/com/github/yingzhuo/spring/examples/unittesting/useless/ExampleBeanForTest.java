package com.github.yingzhuo.spring.examples.unittesting.useless;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("ut")
public class ExampleBeanForTest implements ExampleBean {

    public ExampleBeanForTest() {
        System.out.println("创建这个bean: " + ExampleBeanForTest.class.getSimpleName());
    }

    @Override
    public void doSomething() {
        // 不做任何事情
    }

}
