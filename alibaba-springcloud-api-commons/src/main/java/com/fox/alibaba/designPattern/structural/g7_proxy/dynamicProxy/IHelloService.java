package com.fox.alibaba.designPattern.structural.g7_proxy.dynamicProxy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 15:15
* @version 1.0
*/
//委托类接口
public interface IHelloService {
 /**
  * 方法1
  * @param userName
  * @return
  */
 String sayHello(String userName);

 /**
  * 方法2
  * @param userName
  * @return
  */
 String sayByeBye(String userName);
 }
