package com.fox.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fox.alibaba.pojo.CommonResult;
import com.fox.alibaba.pojo.Payment;
import com.fox.alibaba.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-13 16:34
* @version 1.0
*/

@RestController
@Slf4j
public class PaymentController {
    
	
    private final PaymentService paymentService;
	
    //@Autowired 可以省略
//    @Autowired 
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
 
    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment dept){
        int i = paymentService.create(dept);
        log.info("***************插入成功*******"+i);
        if(i>0){
            return new CommonResult<Integer>(200,"插入数据库成功",i);
        }else{
            return new CommonResult<Integer>(444,"插入数据库失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
 
    public CommonResult<Payment> queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********"+payment);
        if(payment!=null){
            return new CommonResult<Payment>(200,"查询成功",payment);
        }else{
            return new CommonResult<Payment>(444,"查询失败",null);
        }
    }
 
}

