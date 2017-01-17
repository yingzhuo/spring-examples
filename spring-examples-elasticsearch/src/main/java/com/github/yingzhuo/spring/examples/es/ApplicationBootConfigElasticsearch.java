package com.github.yingzhuo.spring.examples.es;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(
        basePackages = "com.github.yingzhuo.spring.examples.es.repo"
)
public class ApplicationBootConfigElasticsearch {

}
