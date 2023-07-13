package com.fox.alibaba.designPattern.behavioral.d4_mediator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:16
* @version 1.0
*/
//具体的客户类-灯
public class Lamp extends Customer {

 public Lamp(Mediator mediator, String name) {
     super(mediator, name);

     // 创建Lamp对象时，将自身注册到中央处理系统的HashMap中
     this.mediator.Register(this.name, this);
 }

 @Override
 public void sendMessage(String message) {
     // 发送的消息，由中央处理系统进行接收并处理
     this.mediator.getMessage(this.name, message);
 }

 public void openLamp() {
     System.out.println("灯已打开，开始向中央处理系统发送关闭闹钟的消息");
     this.sendMessage("关闭闹钟");
 }

}

