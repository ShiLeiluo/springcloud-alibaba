package com.fox.alibaba.designPattern.structural.b2_bridge;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:01
* @version 1.0
*/
public class MilkTea extends Food {
    @Override
    public void add() {
        fruit.beAdd("奶茶");
    }
}
