package com.fox.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fox.alibaba.service.UserService;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-19 14:31
* @version 1.0
*/

@RestController
public class FlowLimitController {
	
	@Autowired
	public UserService userService;
	
    @GetMapping("/testA")
    public String testA() {
    	return "testA ";
    }
 
    @GetMapping("/testB")
    public String testB() {

    	return "testB ";
    }
    
    @GetMapping("/testC")
    public String testC() {
        return "testC "+userService.getUserName();
    }
    
    @GetMapping("/testD")
    public String testD() {
        return "testD "+userService.getUserName();
    }

}
