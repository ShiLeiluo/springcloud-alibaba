package com.fox.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fox.alibaba.pojo.CommonResult;
import com.fox.alibaba.pojo.Payment;
import com.fox.alibaba.service.HelloOpenFeignService;

import lombok.extern.slf4j.Slf4j;


/**
* @author F1337248 ShiLeiluo
* @date 2023-06-14 14:52
* @version 1.0
*/
@RestController
@Slf4j
public class OrderController {
    //调用支付订单服务端的ip+端口号
//    public static final  String PAYMENT_URL = "http://localhost:8001";
    public static final  String PAYMENT_URL = "http://microservice-payment";
 
    @Autowired
    private RestTemplate restTemplate;
    
    private final HelloOpenFeignService feignService;
    
    public OrderController(HelloOpenFeignService feignService) {
		this.feignService = feignService;
	}
    
    //创建支付订单的接口
    @GetMapping("/order/create")
    public CommonResult<Payment> create(Payment payment){
    	log.info("80 order url: /order/create");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    // RestTemplate
    //获取id获取支付订单
    @GetMapping("/order/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
    	log.info("80 order url: /order/get/{id}");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
 
    }
    //获取id获取支付订单
    @GetMapping("/order/hello")
    public CommonResult<CommonResult> hello() {
    	log.info("8080 order url: /order/hello");
    	CommonResult<CommonResult> res = new CommonResult<>();
    	res.setCode(200);
    	res.setMessage("8080");
    	res.setData(restTemplate.getForObject(PAYMENT_URL + "/payment/get/1", CommonResult.class));
    	
        return res;
    }
    
    //获取id获取支付订单
    @GetMapping("/order/helloOpenFeign")
    public CommonResult<CommonResult> helloOpenFeign() {
    	log.info("8080 order url: /order/helloOpenFeign");
    	CommonResult<CommonResult> res = new CommonResult<>();
    	res.setCode(200);
    	res.setMessage("8080");
    	res.setData(feignService.queryById(1L));
    	
        return res;
    }
}