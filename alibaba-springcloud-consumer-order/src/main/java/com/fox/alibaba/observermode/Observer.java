package com.fox.alibaba.observermode;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 10:13
* @version 1.0
*/
public abstract class Observer {
    protected Subject subject;
    public abstract String  update();
}
