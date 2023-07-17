package com.fox.alibaba.designPattern.behavioral.g7_state;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-14 15:43
* @version 1.0
*/
/**
 * 已取消状态处理
 */

public class CancelOrderStatusServiceImpl implements IOrderState {
 
    @Override
    public void handleOrderByState() {
    	System.out.println("已取消状态处理");
    }
}