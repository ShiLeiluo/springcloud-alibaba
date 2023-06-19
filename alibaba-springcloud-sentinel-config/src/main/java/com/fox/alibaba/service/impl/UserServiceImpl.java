package com.fox.alibaba.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fox.alibaba.service.UserService;


/**
* @author F1337248 ShiLeiluo
* @date 2023-06-19 15:02
* @version 1.0
*/
@Service
public class UserServiceImpl implements UserService {
    @Override
    @SentinelResource(value = "getUserName")
    public String getUserName() {
        return "一只tom猫";
    }
}
