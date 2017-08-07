package com.github.yingzhuo.spring.examples.thymeleaf;

import com.github.yingzhuo.spring.examples.thymeleaf.model.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApplicationConfigThymeLeaf extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<Product, String>() {
            @Override
            public String convert(Product source) {
                return source.getName();
            }
        });
    }
}
