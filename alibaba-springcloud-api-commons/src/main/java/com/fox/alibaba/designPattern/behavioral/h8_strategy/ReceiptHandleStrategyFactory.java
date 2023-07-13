package com.fox.alibaba.designPattern.behavioral.h8_strategy;

import java.util.HashMap;
import java.util.Map;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 16:07
* @version 1.0
*/
public class ReceiptHandleStrategyFactory {
	 
    public ReceiptHandleStrategyFactory() {
    }
 
    //使用Map集合存储策略信息,彻底消除if...else
    private static Map<String,ReceiptHandleStrategy> strategyMap;
 
    //初始化具体策略,保存到map集合
    public static void init(){
        strategyMap = new HashMap<>();
        strategyMap.put("MT1011",new Mt1011ReceiptHandleStrategy());
        strategyMap.put("MT2101",new Mt2101ReceiptHandleStrategy());
    }
 
    //根据回执类型获取对应策略类对象
    public static ReceiptHandleStrategy getReceiptHandleStrategy(String receiptType){
        return strategyMap.get(receiptType);
    }
}
