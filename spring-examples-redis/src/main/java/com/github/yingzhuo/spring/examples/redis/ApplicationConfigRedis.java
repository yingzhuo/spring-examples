package com.github.yingzhuo.spring.examples.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yingzhuo.spring.examples.redis.domain.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class ApplicationConfigRedis {

    @Bean(name = {"keyGenerator", "keyGen", "kg"})
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString() != null ? obj.toString() : "null");
            }
            return sb.toString();
        };
    }

    @Bean
    public CacheManager cacheManager(StringRedisTemplate stringRedisTemplate) {
        RedisCacheManager manager = new RedisCacheManager(stringRedisTemplate);
        manager.setDefaultExpiration(TimeUnit.HOURS.toSeconds(2));
        return manager;
    }

    @Bean
    // see: https://github.com/spring-projects/spring-session/issues/387
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(objectMapper());

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }

    private ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(
                mapper.getVisibilityChecker()
                        .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                        .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                        .withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
        );

        mapper.addMixIn(User.class, MixIn.class);
        mapper.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.NON_FINAL, "@class");
        return mapper;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    public static abstract class MixIn {
    }
}
