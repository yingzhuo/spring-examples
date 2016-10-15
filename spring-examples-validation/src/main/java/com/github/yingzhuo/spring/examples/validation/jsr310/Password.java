package com.github.yingzhuo.spring.examples.validation.jsr310;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Constraint(validatedBy=EmailExistsConstraintValidator.class)
public @interface Password {

    String message() default "电话号码格式非法";

    Class[] groups() default {};

    Class[] payload() default {};

}
