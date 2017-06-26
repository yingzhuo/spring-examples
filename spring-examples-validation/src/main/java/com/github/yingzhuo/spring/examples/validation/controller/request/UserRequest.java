/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.validation.controller.request;

import com.github.yingzhuo.spring.examples.validation.jsr310.Password;
import com.github.yingzhuo.spring.examples.validation.jsr310.ValidationGroup;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserRequest implements Serializable {

    @NotNull(message = "姓名为必填", groups = {ValidationGroup.Create.class})
    @Length(min = 2, max = 4, message = "姓名长度必须在{min}和{max}", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String name;

    @NotNull(message = "电子邮件为必填", groups = {ValidationGroup.Create.class})
    @Email(message = "电子邮件非法", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    @Length(min = 3, max = 40, message = "电子邮件长度必须在{min}和{max}", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String email;

    @Length(min = 11, max = 11, message = "电子邮件长度必须为{min}位", groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String phone;

    @NotNull(message = "密码为必填", groups = ValidationGroup.Create.class)
    @Password(groups = {ValidationGroup.Create.class, ValidationGroup.Update.class})
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
