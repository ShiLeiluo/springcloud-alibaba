package com.fox.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-14 11:01
* @version 1.0
*/
@SpringBootApplication
//SpringCloud Edgware(Nov 22, 2017) 版本开始 @EnableDiscoveryClient注解可以省略
//@EnableDiscoveryClient
public class OrderApplication_8081 {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication_8081.class, args);
	}
}
