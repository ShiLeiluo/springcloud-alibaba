package com.fox.alibaba.designPattern.behavioral.d4_mediator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:14
* @version 1.0
*/
// 抽象客户类
public abstract class Customer {
    protected Mediator mediator;
    protected String name;

    public Customer(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    // 客户向中介发送消息，中介根据客户的消息做处理
    public abstract void sendMessage(String message);
}

