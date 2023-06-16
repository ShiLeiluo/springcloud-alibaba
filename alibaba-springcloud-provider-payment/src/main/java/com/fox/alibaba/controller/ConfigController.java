package com.fox.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-16 10:32
* @version 1.0
*/
@RefreshScope
@RestController
@Slf4j
public class ConfigController {
    @Value("${config.info}")
    private  String configInfo;
    
    @GetMapping("/config/info")
    public String getConfigInfo(){
        log.info(configInfo);
        return configInfo;
    }
}
