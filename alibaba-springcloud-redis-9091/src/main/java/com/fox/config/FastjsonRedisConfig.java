package com.fox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-05 14:51
* @version 1.0
*/
@Configuration
public class FastjsonRedisConfig {
 
    /**
     * 自定义redisTemplate配置
     *
     * 使用的序列化方式
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //key值使用spring默认的StringRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //value值使用fastjson的GenericFastJsonRedisSerializer
        GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        //以下是hash序列化的配置
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
 
        return redisTemplate;
    }
 
}
