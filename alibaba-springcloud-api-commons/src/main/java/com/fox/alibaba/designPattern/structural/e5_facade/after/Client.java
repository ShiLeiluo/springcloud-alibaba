package com.fox.alibaba.designPattern.structural.e5_facade.after;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 10:05
* @version 1.0
*/

public class Client {
    public static void main(String[] args) {
        PurchurseFacade purchurseFacade = new PurchurseFacade();
        //购买过程
        purchurseFacade.purchurseGoods("华为mate30","圆通快递");
    }
}


