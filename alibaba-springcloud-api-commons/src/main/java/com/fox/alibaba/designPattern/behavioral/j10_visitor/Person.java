package com.fox.alibaba.designPattern.behavioral.j10_visitor;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-15 15:36
* @version 1.0
*/
public abstract class Person {
    //提供一个方法，让访问者可以访问
    public abstract void accept(Action action);
}


