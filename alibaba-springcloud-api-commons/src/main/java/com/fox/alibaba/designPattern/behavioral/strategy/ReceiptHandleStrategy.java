package com.fox.alibaba.designPattern.behavioral.strategy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 15:46
* @version 1.0
*/
/**
 * 回执处理策略接口
 * @author F1337248
 *
 */
public interface ReceiptHandleStrategy {

	//回执处理
	
	//接收到的回执信息
	void handleReceipt(Receipt receipt);
}
