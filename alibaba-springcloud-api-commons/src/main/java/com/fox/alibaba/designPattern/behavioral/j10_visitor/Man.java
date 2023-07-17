package com.fox.alibaba.designPattern.behavioral.j10_visitor;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-15 15:36
* @version 1.0
*/
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}


