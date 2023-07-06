package com.fox;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-05 10:38
* @version 1.0
*/
@SpringBootApplication
@EnableDiscoveryClient
public class RedisApplication_9091 {
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication_9091.class, args);
	}
}
