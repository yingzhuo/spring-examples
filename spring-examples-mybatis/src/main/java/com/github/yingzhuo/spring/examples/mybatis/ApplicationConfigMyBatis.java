package com.github.yingzhuo.spring.examples.mybatis;

import org.apache.ibatis.session.ExecutorType;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class ApplicationConfigMyBatis {

    @Autowired
    private DataSource dataSource;

    @Bean
    @DependsOn("dataSource")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setFailFast(true);
        factoryBean.setConfigLocation(new ClassPathResource("mybatis.cnf.xml"));
        return factoryBean;
    }

    @Bean
    @DependsOn("dataSource")
    public SqlSessionTemplate sqlSessionTemplate(DataSource dataSource) throws Exception {
        return new SqlSessionTemplate(
                sqlSessionFactoryBean().getObject(),
                ExecutorType.SIMPLE,
                new MyBatisExceptionTranslator(dataSource, false)
        );
    }

    @Bean
    @DependsOn("dataSource")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
