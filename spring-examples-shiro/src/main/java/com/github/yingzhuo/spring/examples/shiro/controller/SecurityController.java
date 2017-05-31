package com.github.yingzhuo.spring.examples.shiro.controller;

import com.github.yingzhuo.spring.examples.shiro.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")
public class SecurityController {

    @GetMapping(value = "login")
    public String login() {
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername("yingzhuo");
        token.setPassword("133810".toCharArray());

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        return "OK";
    }

    @GetMapping(value = "logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "OK";
    }

    @RequiresAuthentication
    @GetMapping(value = "who")
    public String who() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return user.getUsername();
    }

}
