package com.fox.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fox.alibaba.pojo.CommonResult;
import com.fox.alibaba.pojo.Payment;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-28 10:13
* @version 1.0
*/
@Component
@FeignClient(value = "microservice-payment")
public interface HelloOpenFeignService {

	 @GetMapping(value = "/payment/get/{id}")
	 public CommonResult<Payment> queryById(@PathVariable("id") Long id);
}
