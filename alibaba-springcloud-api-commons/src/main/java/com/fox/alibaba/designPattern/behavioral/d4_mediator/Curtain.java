package com.fox.alibaba.designPattern.behavioral.d4_mediator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:15
* @version 1.0
*/
//具体的客户类-窗帘
public class Curtain extends Customer {

 public Curtain(Mediator mediator, String name) {
     super(mediator, name);

     // 创建Curtain对象时，将自身注册到中央处理系统的HashMap中
     this.mediator.Register(this.name, this);
 }

 @Override
 public void sendMessage(String message) {
     // 窗帘不控制其它家电，不用实现该方法
 }

 public void openCurtain() {
     System.out.println("窗帘已打开");
 }

}

