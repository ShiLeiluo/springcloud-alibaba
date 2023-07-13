package com.fox.alibaba.designPattern.behavioral.e5_memento;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-12 14:16
* @version 1.0
*/
public class Memento {
    private String state;
    
    public Memento(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}
