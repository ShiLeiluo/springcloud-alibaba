package com.fox.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fox.alibaba.pojo.Payment;
import com.fox.service.PaymentService;


/**
* @author F1337248 ShiLeiluo
* @date 2023-07-01 17:17
* @version 1.0
*/
@RestController
public class HelloController {
	
	private final PaymentService paymentService;

	
    public HelloController(PaymentService paymentService) {
    	this.paymentService = paymentService;
    }
    
    @GetMapping("/hello")
    public String hello() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Payment queryById = paymentService.queryById(1);
		return sdf.format(new Date())+"\nhello 9090"+"\n70_Serial:"+queryById.getSerial();
    }
}
