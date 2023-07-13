package com.fox.alibaba.designPattern.behavioral.e5_memento;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-12 14:16
* @version 1.0
*/
//原发器类 Originator，它包含了需要保存和恢复的状态，并提供了创建备忘录和从备忘录恢复状态的方法

public class Originator {
    private String state;
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public Memento createMemento() {
        return new Memento(state);
    }
    
    public void restoreFromMemento(Memento memento) {
        state = memento.getState();
    }
}
