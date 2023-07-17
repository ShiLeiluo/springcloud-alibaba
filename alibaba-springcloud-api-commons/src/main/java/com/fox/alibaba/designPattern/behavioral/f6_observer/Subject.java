package com.fox.alibaba.designPattern.behavioral.f6_observer;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 18:48
* @version 1.0
* 定义主题类型
* 其中定义可以新增删除 通知观察者的方法
*/
public class Subject {
	
	//储存游资和基金的对象
	List<ShareObserver> list = new ArrayList<>();
	
	//新增观察者
	public void add(ShareObserver shareObserver) {
		list.add(shareObserver);
	}
	
	//通知观察者
	public void change(int j) {
		for (int i = 0; i < list.size(); i++) {
			ShareObserver shareObserver = list.get(i);
			shareObserver.response(j);
		}
	}
	

}
