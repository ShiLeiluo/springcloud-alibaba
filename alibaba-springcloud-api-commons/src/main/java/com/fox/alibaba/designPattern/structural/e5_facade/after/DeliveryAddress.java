package com.fox.alibaba.designPattern.structural.e5_facade.after;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 10:06
* @version 1.0
*/
/**
 * 增加选择邮件地址
 */
public class DeliveryAddress {
    /**
     * 选择邮寄地址
     * @param address
     */
    public void addAddress(String address){
        System.out.println("选择邮寄地址:"+address);
    }

}

