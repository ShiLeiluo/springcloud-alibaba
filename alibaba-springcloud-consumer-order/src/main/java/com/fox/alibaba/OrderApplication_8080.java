package com.fox.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-14 11:01
* @version 1.0
*/
@EnableFeignClients
@SpringBootApplication
//SpringCloud Edgware(Nov 22, 2017) 版本开始 @EnableDiscoveryClient注解可以省略
//@EnableDiscoveryClient
public class OrderApplication_8080 {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication_8080.class, args);
	}
}
