/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
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
