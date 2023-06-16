package com.fox.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-13 14:55
* @version 1.0
*/
@SpringBootApplication
@EnableDiscoveryClient
//该注解支持nacos的动态刷新的功能，Springcloud原生的注解，实现配置自动更新
@RefreshScope 
public class PaymentApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
}
