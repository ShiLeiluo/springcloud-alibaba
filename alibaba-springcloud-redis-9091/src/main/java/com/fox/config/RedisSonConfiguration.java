package com.fox.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
* @author F1337248 ShiLeiluo
* @date 2023-07-05 15:21
* @version 1.0
*/
@Configuration
public class RedisSonConfiguration {
 
    @Value("${spring.redis.host}")
    private String address;
 
    @Value("${spring.redis.port}")
    private String port;
 
    @Value("${spring.redis.password}")
    private String password;
 
    @Value("${spring.redis.database}")
    private String database;
 
    @Value("${spring.redis.timeout}")
    private String timeout;
 
    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(address())
                .setPassword(password)
                .setDatabase(Integer.parseInt(database))
                .setConnectTimeout(Integer.parseInt(timeout));
        return Redisson.create(config);
    }
 
    /**
     * 生成address
     * @return
     */
    private String address() {
        return "redis://" + address + ":" + port;
    }
}
