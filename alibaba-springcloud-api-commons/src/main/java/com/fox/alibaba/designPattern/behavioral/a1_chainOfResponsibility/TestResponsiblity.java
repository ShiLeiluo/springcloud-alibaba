package com.fox.alibaba.designPattern.behavioral.a1_chainOfResponsibility;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 11:21
* @version 1.0
*/
public class TestResponsiblity {
	public static void main(String[] args) {
		//定义消息类
		Msg msg = new Msg();
		msg.setMsg("你好，------,我是***琪琪.....");
		//new msg处理对象和http处理对象
		HttpFilter httpFilter = new HttpFilter();
		MsgFilter msgFilter = new MsgFilter();
		//new 责任链处理对象
		FatherFilterChain fatherFilterChain = new FatherFilterChain();
		//将http处理对象和msg处理对象加入责任链
		fatherFilterChain.add(msgFilter);
		fatherFilterChain.add(httpFilter);
		fatherFilterChain.doFilter(msg.getMsg());
	}
//	 我们可以看到，所谓的责任链模式，说白了就是利用了多态的特性，
//	 将对象封装成集合，在调用方法时循环调用对象的方法，
//	 利用循环进行调用，
//	 责任链模式的典型应用场景就是spring的filter类，有兴趣的可以看下源码。
//	 类似观察者模式
}
