package com.fox.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    //定义一个全局变量，模拟商品总数
    private static int count = 20;
 
    @Autowired
    private RedissonClient redissonClient;

	@Autowired
    private RedisTemplate<String, String> redisTemplate;
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
    	ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//    	opsForValue.set("key1", "helloRedis");
    	String redis = opsForValue.get("key1");
    	
    	sb.append("redis: " + redis.toString());
    	
    	testRedisSon();
    	log.info(sb.toString().replace("<br />\n", " "));
		return sb.toString();
    }
    /**
     * 使用分布式锁
     * 循环100次，创建100个线程进行模拟下单，当个数为0时，抛出异常终止程序   
     */
    public String testRedisSon() {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    RLock lock = redissonClient.getLock("test-lock");
                    try {
                        if (lock.tryLock(1000, 1000, TimeUnit.SECONDS)) {
                            if (count <= 0) {
                                throw new RuntimeException("商品已经卖完了，下次再来吧！");
                            }
                            System.out.println("count的值：" + count--);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
            thread.start();
        }
        return "success";
    }
}
