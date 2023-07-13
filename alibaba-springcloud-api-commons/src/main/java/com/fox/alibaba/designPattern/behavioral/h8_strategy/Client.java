package com.fox.alibaba.designPattern.behavioral.h8_strategy;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 16:08
* @version 1.0
*/
public class Client {
	 
    public static void main(String[] args) {
 
       //模拟收到回执信息
        List<Receipt> receiptList = new ArrayList<>();
        receiptList.add(new Receipt("MT1011","MT1101回执"));
        receiptList.add(new Receipt("MT2101","MT2101回执"));
//        receiptList.add(new Receipt("MT4101回执","MT4101"));
//        receiptList.add(new Receipt("MT8104回执","MT8104"));
 
 
        //策略上下文
        ReceiptStrategyContext context = new ReceiptStrategyContext();
 
        //策略模式将策略的 定义、创建、使用这三部分进行了解耦
        for (Receipt receipt : receiptList) {
            //获取置策略
            ReceiptHandleStrategyFactory.init();
            ReceiptHandleStrategy strategy = ReceiptHandleStrategyFactory.getReceiptHandleStrategy(receipt.getType());
            //设置策略
            context.setReceiptHandleStrategy(strategy);
            //执行策略
            context.handleReceipt(receipt);
        }
    }
}
