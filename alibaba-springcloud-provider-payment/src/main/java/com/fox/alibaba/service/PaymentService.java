package com.fox.alibaba.service;

import org.apache.ibatis.annotations.Param;

import com.fox.alibaba.pojo.Payment;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-13 16:16
* @version 1.0
*/
public interface PaymentService {
    int create(Payment payment);
    
    Payment queryById(@Param("id")long id);
}
