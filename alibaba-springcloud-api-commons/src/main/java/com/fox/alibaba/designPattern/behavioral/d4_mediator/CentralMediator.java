package com.fox.alibaba.designPattern.behavioral.d4_mediator;

import java.util.HashMap;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 17:17
* @version 1.0
*/
 // 具体的中介者-中央处理系统
public class CentralMediator extends Mediator {
    // 保存所有的家电对象
    private HashMap<String, Customer> customerMap;
    // 保存所有的电器种类名称和电器名称
    private HashMap<String, String> nameMap;

    public CentralMediator() {
        this.customerMap = new HashMap<String, Customer>();
        this.nameMap = new HashMap<String, String>();
    }

    @Override
    public void Register(String customerName, Customer customer) {
        this.customerMap.put(customerName, customer);

        if (customer instanceof Alarm) {
            this.nameMap.put("Alarm", customerName);
        } else if (customer instanceof Curtain) {
            this.nameMap.put("Curtain", customerName);
        } else if (customer instanceof Lamp) {
            this.nameMap.put("Lamp", customerName);
        }
    }

    // 接收家电发送的消息，并做出相应的处理
    @Override
    public void getMessage(String customerName, String message) {
        // 处理闹钟发出的消息
        if (this.customerMap.get(customerName) instanceof Alarm) {
            if (message == "开启窗帘") {
                // 调用窗帘，进行窗帘的打开
                ((Curtain) this.customerMap.get(this.nameMap.get("Curtain"))).openCurtain();
            }
        } else if (this.customerMap.get(customerName) instanceof Lamp) {
            if (message == "关闭闹钟") {
                // 调用闹钟，进行闹钟的关闭
                ((Alarm) this.customerMap.get(this.nameMap.get("Alarm"))).closeAlarm();
            }
        }

    }

}
