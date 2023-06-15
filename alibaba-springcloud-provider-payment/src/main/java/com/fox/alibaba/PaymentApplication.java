package com.fox.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-13 14:55
* @version 1.0
*/
@SpringBootApplication
@EnableDiscoveryClient

public class PaymentApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}
}
