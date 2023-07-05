package com.fox.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fox.alibaba.pojo.Payment;
import com.fox.service.PaymentService;

import lombok.extern.slf4j.Slf4j;


/**
* @author F1337248 ShiLeiluo
* @date 2023-07-01 17:17
* @version 1.0
*/
@RestController
@Slf4j
public class HelloController {
	
	private final PaymentService paymentService;

    public HelloController(PaymentService paymentService) {
    	this.paymentService = paymentService;
    }
    
    @GetMapping("/helloRedis")
    public String hello() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	StringBuffer sb = new StringBuffer();
    	sb.append(sdf.format(new Date()));
    	sb.append("<br />\n");
    	sb.append("hello 9090");
    	sb.append("<br />\n");
    	Payment queryById = paymentService.queryById(1);
    	sb.append("70_Serial: " + queryById.getSerial());
    	sb.append("<br />\n");
    	log.info(sb.toString().replace("<br />", ""));
		return sb.toString();
    }
}
