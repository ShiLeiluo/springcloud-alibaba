package com.fox.alibaba.designPattern.structural.e5_facade.after;

import com.fox.alibaba.designPattern.structural.e5_facade.before.PurchurseProcess;
import com.fox.alibaba.designPattern.structural.e5_facade.before.PurchurseProcessImpl;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 10:05
* @version 1.0
*/
/**
 * 定义门面
 */
/**
 * 定义门面
 */
public class PurchurseFacade {

    private PurchurseProcess purchurseProcess = new PurchurseProcessImpl();

    //增加选择地址
    private  DeliveryAddress deliveryAddress = new DeliveryAddress();
    //选择支付方式
    private PayModeFacde payModeFacde = new PayModeFacde();

    /**
     * 一个方法实现四个步骤
     * @param goodName 商品名字
     * @param deliveryMode 快递方式
     */
   public void purchurseGoods(String goodName,String deliveryMode) {
       //1.挑选物品
       purchurseProcess.pickGoods(goodName);
       //2.添加购物车
       purchurseProcess.addCart(goodName);
       //添加快递地址
       deliveryAddress.addAddress("xx省");
       //3.选择快递方式
       purchurseProcess.chooseDelivMode(deliveryMode);
       //增加
       payModeFacde.selectPayMode("支付宝");
       //4.支付完成
       purchurseProcess.pay();
   }
}



