package com.fox.alibaba.designPattern.behavioral.e5_memento;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-12 15:13
* @version 1.0
*/
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        
        // 设置原发器的状态
        originator.setState("State 1");
        System.out.println("Initial state: " + originator.getState());
        
        // 创建备忘录并保存到管理者
        caretaker.setMemento(originator.createMemento());
        
        // 修改原发器的状态
        originator.setState("State 2");
        System.out.println("Updated state: " + originator.getState());
        
        // 从备忘录中恢复原发器的状态
        originator.restoreFromMemento(caretaker.getMemento());
        System.out.println("Restored state: " + originator.getState());
    }
}