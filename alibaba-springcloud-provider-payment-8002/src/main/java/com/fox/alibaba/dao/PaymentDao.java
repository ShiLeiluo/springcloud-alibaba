package com.fox.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fox.alibaba.pojo.Payment;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-23 14:44
* @version 1.0
*/
@Mapper
@Repository
public interface PaymentDao {
    int create(Payment payment);
    Payment queryById(@Param("id")long id);
}
