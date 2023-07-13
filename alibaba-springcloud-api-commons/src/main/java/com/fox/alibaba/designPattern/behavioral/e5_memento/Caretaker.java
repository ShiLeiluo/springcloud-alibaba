package com.fox.alibaba.designPattern.behavioral.e5_memento;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-12 15:12
* @version 1.0
*/
//创建管理者类 Caretaker，它负责存储和恢复备忘录对象
public class Caretaker {
    private Memento memento;
    
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    
    public Memento getMemento() {
        return memento;
    }
}
