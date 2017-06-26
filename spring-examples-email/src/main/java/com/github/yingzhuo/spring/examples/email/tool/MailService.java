/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **     |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.email.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@Component
public class MailService implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    private String from;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(from);
    }

    public boolean sendMimeMessage(String sendTo, String subject, String html) {
        return sendMimeMessage(new String[] {sendTo}, subject, html);
    }

    public boolean sendMimeMessage(String[] sendTo, String subject, String html) {
        return sendMimeMessageWithAttachments(sendTo, subject, html, null);
    }

    public boolean sendMimeMessageWithAttachments(String[] sendTo, String subject, String html, Map<String, File> attachmentMap) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setFrom(from);
            helper.setTo(sendTo);
            helper.setSubject(subject);
            helper.setText(html, true);

            if (attachmentMap != null && !attachmentMap.isEmpty()) {
                for (String attachmentFilename : attachmentMap.keySet()) {
                    helper.addAttachment(attachmentFilename, attachmentMap.get(attachmentFilename));
                }
            }
            javaMailSender.send(mail);
            return true;
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }

    @Value("${spring.mail.username}")
    public void setFrom(String from) {
        this.from = from;
    }

}
