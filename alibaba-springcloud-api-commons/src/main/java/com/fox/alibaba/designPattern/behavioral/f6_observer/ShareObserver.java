package com.fox.alibaba.designPattern.behavioral.f6_observer;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 18:43
* @version 1.0
* 定义股票观察者父类
*/
public interface ShareObserver {
	//观察之后做出如何反应
	public void response(int i);
}
