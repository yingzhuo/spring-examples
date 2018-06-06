/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                                |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.exceldownloading;

import com.github.yingzhuo.spring.examples.exceldownloading.view.ExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;

import java.util.Optional;

/**
 * @author 应卓
 */
@Configuration
public class ApplicationCnfMvc implements WebMvcConfigurer {

    @Autowired(required = false)
    public void configBeanNameViewResolver(BeanNameViewResolver resolver) {
        Optional.ofNullable(resolver).ifPresent(it -> {
            resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
        });
    }

    @Bean
    public ExcelView excelView() {
        return new ExcelView();
    }

}
