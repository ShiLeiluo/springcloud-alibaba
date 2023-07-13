package com.fox.alibaba.designPattern.behavioral.h8_strategy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 16:07
* @version 1.0
*/
/**
 * 上下文类,持有策略接口
 **/
public class ReceiptStrategyContext {
 
    private ReceiptHandleStrategy receiptHandleStrategy;
 
    public void setReceiptHandleStrategy(ReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }
 
    //调用策略类中的方法
    public void handleReceipt(Receipt receipt){
        if(receipt != null){
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }
}
