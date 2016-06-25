package com.github.yingzhuo.spring.examples.hsqldb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

//@Configuration
public class ApplicationConfigDataSource {

    @Bean
    @Primary
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/hsqldb/schema.sql")
                .addScript("classpath:/hsqldb/data.sql")
                .build();
    }

}
