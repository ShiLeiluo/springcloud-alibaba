package com.fox.alibaba.designPattern.behavioral.d4_mediator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:19
* @version 1.0
*/
public class MediatorTest {

    public static void main(String[] args) {

        // 创建一个中介者对象
        Mediator mediator = new CentralMediator();

        // 创建各个Customer对象并且加入到CentralMediator对象的HashMap中
        Alarm alarm = new Alarm(mediator, "alarm");
        Curtain curtain = new Curtain(mediator, "curtain");
        Lamp lamp = new Lamp(mediator, "lamp");

        // 闹钟响了，会自动打开窗帘
        alarm.openAlarm();
        curtain.openCurtain();
//        // 灯开了，会自动关闭闹钟
        lamp.openLamp();
    }

}
