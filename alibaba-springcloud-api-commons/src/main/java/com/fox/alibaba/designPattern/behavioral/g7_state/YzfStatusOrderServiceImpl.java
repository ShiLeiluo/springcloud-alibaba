package com.fox.alibaba.designPattern.behavioral.g7_state;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-14 15:43
* @version 1.0
*/
/**
 * 已支付状态
 */
public class YzfStatusOrderServiceImpl implements IOrderState {
 
    @Override
    public void handleOrderByState() {
        //
    	System.out.println("已支付状态处理");
    }
}
