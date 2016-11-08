package com.github.yingzhuo.spring.examples.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetSocketAddress;

@Configuration
@EnableElasticsearchRepositories(
        basePackages = "com.github.yingzhuo.spring.examples.es.repo"
)
@PropertySource("classpath:/elasticsearch.properties")
public class ApplicationBootConfigElasticsearch {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;


    @Bean
    public Client elasticsearchClient() {
        TransportClient client = new TransportClient.Builder().build();
        TransportAddress address = new InetSocketTransportAddress(new InetSocketAddress(host, port));
        client.addTransportAddress(address);
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(elasticsearchClient());
    }

}
