package com.fox.alibaba.designPattern.structural.b2_bridge;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 14:59
* @version 1.0
*/
public abstract class Food {
    //水果
    Fruit fruit;
    
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
    /**
     * 制作时添加
     */
    public abstract void add();
}
