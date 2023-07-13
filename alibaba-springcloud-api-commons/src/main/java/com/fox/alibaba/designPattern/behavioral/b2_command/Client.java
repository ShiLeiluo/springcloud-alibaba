package com.fox.alibaba.designPattern.behavioral.b2_command;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 16:00
* @version 1.0
*/
public class Client {
	public static void main(String[] args) {
		// 创建接收者
		Receiver receiver = new Receiver();
		// 创建命令对象，设定它的接收者
		Command command = new ConcreteCommand(receiver);
		// 创建调用者，把命令对象设置进去
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		// 调用者调用命令
		invoker.invoke();
	}
}
