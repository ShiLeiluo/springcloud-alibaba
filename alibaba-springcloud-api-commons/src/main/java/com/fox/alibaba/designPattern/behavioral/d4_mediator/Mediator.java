package com.fox.alibaba.designPattern.behavioral.d4_mediator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:16
* @version 1.0
*/
 // 抽象中介者
public abstract class Mediator {
    // 将中介者的客户注册到HashMap中
    public abstract void Register(String customerName, Customer customer);

    // 接收客户的消息, 并根据消息和其它客户交互
    public abstract void getMessage(String customerName, String message);

}
