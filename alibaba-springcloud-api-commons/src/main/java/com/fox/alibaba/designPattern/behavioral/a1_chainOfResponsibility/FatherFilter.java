package com.fox.alibaba.designPattern.behavioral.a1_chainOfResponsibility;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 11:08
* @version 1.0
* 定义处理消息的接口
*/
public interface FatherFilter {
	//定义处理消息的方法
	
	public String doFilter(String msg);

}
