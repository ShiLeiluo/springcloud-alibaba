package com.fox.alibaba.designPattern.structural.g7_proxy.staticProxy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 10:55
* @version 1.0
*/
//代理类
public class StaticProxyHello implements IHelloService {

 private IHelloService helloService = new HelloService();

 @Override
 public String sayHello(String userName) {
     /** 代理对象可以在此处包装一下*/
     System.out.println("代理对象包装礼盒...");
     return helloService.sayHello(userName);
 }
}
