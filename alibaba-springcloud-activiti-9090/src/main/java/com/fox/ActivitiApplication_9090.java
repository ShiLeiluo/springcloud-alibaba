package com.fox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
* @author F1337248 ShiLeiluo
* @date 2023-06-30 15:12
* @version 1.0
*/

@EnableDiscoveryClient
@SpringBootApplication

public class ActivitiApplication_9090 {
	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication_9090.class, args);
	}
}
