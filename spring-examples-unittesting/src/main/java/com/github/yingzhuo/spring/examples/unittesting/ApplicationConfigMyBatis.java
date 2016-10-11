package com.github.yingzhuo.spring.examples.unittesting;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.github.yingzhuo.spring.examples.unittesting"}, annotationClass = Mapper.class)
public class ApplicationConfigMyBatis {

}
