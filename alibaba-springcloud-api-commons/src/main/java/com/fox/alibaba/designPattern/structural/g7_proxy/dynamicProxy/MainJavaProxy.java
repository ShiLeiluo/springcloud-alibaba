package com.fox.alibaba.designPattern.structural.g7_proxy.dynamicProxy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 15:32
* @version 1.0
*/
//测试动态代理类
public class MainJavaProxy {
 public static void main(String[] args) {
     JavaProxyInvocationHandler proxyInvocationHandler = new JavaProxyInvocationHandler(new HelloService());
     IHelloService helloService = (IHelloService) proxyInvocationHandler.newProxyInstance();
     helloService.sayByeBye("java");
     helloService.sayHello("java");
 }
}

