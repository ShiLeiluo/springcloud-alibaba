package com.fox.alibaba.designPattern.structural.e_facade.before;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:46
* @version 1.0
*/
/**
 * 定义一个购物处理过程
 */
public interface PurchurseProcess {

    //挑选商品
    void pickGoods(String goodName);

    //添加购物车
    void addCart(String goodName);

    //选择快递方式
    void chooseDelivMode(String delivName);

    //支付
    void pay();

}

