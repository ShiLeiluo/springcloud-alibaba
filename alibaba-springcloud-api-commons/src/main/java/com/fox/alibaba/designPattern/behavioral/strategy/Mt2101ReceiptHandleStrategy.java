package com.fox.alibaba.designPattern.behavioral.strategy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 16:04
* @version 1.0
*/
public class Mt2101ReceiptHandleStrategy implements ReceiptHandleStrategy {
	 
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT2101: " + receipt.getMessage());
    }
}
