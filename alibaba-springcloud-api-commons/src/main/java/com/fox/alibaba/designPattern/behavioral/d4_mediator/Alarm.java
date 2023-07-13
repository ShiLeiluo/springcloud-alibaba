package com.fox.alibaba.designPattern.behavioral.d4_mediator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:15
* @version 1.0
*/
//具体的客户类-闹钟
public class Alarm extends Customer {

 public Alarm(Mediator mediator, String name) {
     super(mediator, name);

     // 创建Alarm对象时，将自身注册到中央处理系统的HashMap中
     this.mediator.Register(this.name, this);
 }

 @Override
 public void sendMessage(String message) {
     // 发送的消息，由中央处理系统进行接收并处理
     this.mediator.getMessage(this.name, message);
 }

 public void openAlarm() {
     System.out.println("闹钟响了，开始向中央处理系统发送开启窗帘的消息");
     this.sendMessage("开启窗帘");
 }

 public void closeAlarm() {
     System.out.println("闹钟已关闭");
 }

}

