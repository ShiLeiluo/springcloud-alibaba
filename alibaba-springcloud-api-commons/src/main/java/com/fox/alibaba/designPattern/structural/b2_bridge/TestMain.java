package com.fox.alibaba.designPattern.structural.b2_bridge;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:02
* @version 1.0
*/
public class TestMain {
	 
    public static void main(String[] args) {
 
        //蛋糕
        Fruit mango = new Mango();
        
        
        Food cake = new Cake();
        cake.setFruit(mango);
        cake.add();
        //牛奶
        Food milk = new Milk();
        milk.setFruit(mango);
        milk.add();
    }
}
