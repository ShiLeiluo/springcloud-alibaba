package com.fox.alibaba.service.impl;

import org.springframework.stereotype.Component;

import com.fox.alibaba.api.InfoService;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-27 13:57
* @version 1.0
*/

@Component
public class InfoServiceImpl implements InfoService {

 @Override
 public String getInfo() {

     return "hello，这里是dubbo-provider-8001模块！";
 }
}