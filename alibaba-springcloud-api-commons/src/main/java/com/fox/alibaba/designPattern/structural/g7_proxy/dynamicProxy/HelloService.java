package com.fox.alibaba.designPattern.structural.g7_proxy.dynamicProxy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 15:30
* @version 1.0
*/
//委托类
public class HelloService implements IHelloService {
 @Override
 public String sayHello(String userName) {
     System.out.println(userName + " hello");
     return userName + " hello";
 }

 @Override
 public String sayByeBye(String userName) {
     System.out.println(userName + " ByeBye");
     return userName + " ByeBye";
 }
}

