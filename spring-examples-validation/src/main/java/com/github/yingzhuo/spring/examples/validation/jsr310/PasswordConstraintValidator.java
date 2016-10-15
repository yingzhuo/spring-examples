package com.github.yingzhuo.spring.examples.validation.jsr310;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<Password, String> {

    @Override
    public void initialize(Password constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO: 在这里判断value是否满足密码的复杂度 合格返回true否者false
        return false;
    }
}
