package com.fox.alibaba.designPattern.structural.g7_proxy.staticProxy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 10:54
* @version 1.0
*/
//委托类实现
public class HelloService implements IHelloService {

 @Override
 public String sayHello(String userName) {
     System.out.println("helloService: " + userName);
     return "HelloService" + userName;
 }
}

