package com.github.yingzhuo.spring.examples.jms.mdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class QueueMessageDrivenBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueMessageDrivenBean.class);

    @JmsListener(destination = "queue.test")
    public void onMessage(Message message) throws Exception {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            LOGGER.debug(textMessage.getText());
        }
    }
}
