package com.fox.alibaba.designPattern.behavioral.j10_visitor;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-15 15:35
* @version 1.0
*/
public abstract class Action {
    //得到男性 的测评
    public abstract void getManResult(Man man);

    //得到女的 测评
    public abstract void getWomanResult(Woman woman);
}


