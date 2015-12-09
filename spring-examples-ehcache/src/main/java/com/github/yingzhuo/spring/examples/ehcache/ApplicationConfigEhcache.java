package com.github.yingzhuo.spring.examples.ehcache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableCaching
public class ApplicationConfigEhcache extends CachingConfigurerSupport {

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheManager cacheManager() {
        List<CacheManager> cacheManagers = new LinkedList<>();

        if (ehCacheCacheManager() != null) {
            cacheManagers.add(ehCacheCacheManager());
        }

        CompositeCacheManager cacheManager = new CompositeCacheManager();
        cacheManager.setCacheManagers(cacheManagers);
        cacheManager.setFallbackToNoOpCache(false);
        return cacheManager;
    }

}
