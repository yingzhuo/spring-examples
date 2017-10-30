/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **     |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.validation2.controller;

import com.github.yingzhuo.spring.examples.validation2.controller.request.UserRequest;
import com.github.yingzhuo.spring.examples.validation2.controller.request.UserRequestValidator;
import com.github.yingzhuo.spring.examples.validation2.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRequestValidator userRequestValidator;

    public UserController(UserRequestValidator userRequestValidator) {
        this.userRequestValidator = userRequestValidator;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userRequestValidator);
    }

    @PostMapping
    public User registerUser(@Validated @RequestBody UserRequest request) {
        User user = new User();
        user.setId(request.getId());
        user.setName(request.getName());
        return user;
    }

}
