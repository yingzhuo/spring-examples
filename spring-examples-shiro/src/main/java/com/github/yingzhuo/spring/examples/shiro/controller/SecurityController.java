package com.github.yingzhuo.spring.examples.shiro.controller;

import com.github.yingzhuo.spring.examples.shiro.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername("yingzhuo");
        token.setPassword("133810".toCharArray());

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        return "OK";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "OK";
    }

    @RequestMapping(value = "who", method = RequestMethod.GET)
    public String who() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return user.getUsername();
    }
}
