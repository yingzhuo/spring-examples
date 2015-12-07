package com.github.yingzhuo.spring.examples.jms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Queue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ApplicationBoot.class)
public class JmsTests {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "queue.test")
    private Queue destination;

    @Test
    public void test1() {
        jmsTemplate.send(destination, session -> session.createTextMessage("你好"));
    }
}
