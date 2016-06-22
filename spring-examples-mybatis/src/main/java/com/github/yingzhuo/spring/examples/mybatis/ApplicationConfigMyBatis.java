package com.github.yingzhuo.spring.examples.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.github.yingzhuo.spring.examples.mybatis"}, annotationClass = Mapper.class)
public class ApplicationConfigMyBatis {

}
