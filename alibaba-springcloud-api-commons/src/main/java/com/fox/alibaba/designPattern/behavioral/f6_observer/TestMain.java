package com.fox.alibaba.designPattern.behavioral.f6_observer;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 18:52
* @version 1.0
* 测试类
*/
public class TestMain {
	public static void main(String[] args) {
		CompanyObserver companyObserver = new CompanyObserver();
		PersonObserver personObserver = new PersonObserver();
		Subject subject = new Subject();
		subject.add(companyObserver);
		subject.add(personObserver);
		subject.change(2);
		System.out.println("******************************");
		subject.change(0);
	}
//	观察者模式类似于责任链模式，所以观察者模式一般配合责任链模式使用
}
