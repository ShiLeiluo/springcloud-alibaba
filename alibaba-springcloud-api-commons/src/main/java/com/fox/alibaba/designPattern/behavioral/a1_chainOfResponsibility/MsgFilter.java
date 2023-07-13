package com.fox.alibaba.designPattern.behavioral.a1_chainOfResponsibility;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 11:13
* @version 1.0
* 处理消息的类
* 过滤消息
*/
public class MsgFilter implements FatherFilter {

	@Override
	public String doFilter(String msg) {
		// TODO Auto-generated method stub
		String replace = msg.replace("*", "");
		System.out.println("Msg Filter replace: "+replace);
		return replace;
	}

}
