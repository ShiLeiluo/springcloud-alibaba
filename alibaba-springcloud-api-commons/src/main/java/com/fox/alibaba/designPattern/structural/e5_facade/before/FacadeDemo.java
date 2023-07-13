package com.fox.alibaba.designPattern.structural.e5_facade.before;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:47
* @version 1.0
*/
/**
 * 模拟一个购物下单的过程
 */
public class FacadeDemo {
    public static void main(String[] args) {
        PurchurseProcessImpl process = new PurchurseProcessImpl();
        //1.挑选物品
        process.pickGoods("联想电脑");
        //2.添加购物车
        process.addCart("联想电脑");
        //3.选择快递方式
        process.chooseDelivMode("京东快递");
        //4.支付完成
        process.pay();
    }
}

