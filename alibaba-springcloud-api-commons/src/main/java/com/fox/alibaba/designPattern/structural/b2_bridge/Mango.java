package com.fox.alibaba.designPattern.structural.b2_bridge;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:02
* @version 1.0
*/
public class Mango implements Fruit {
    @Override
    public void beAdd(String food) {
        System.out.println("芒果" + food);
    }
}
