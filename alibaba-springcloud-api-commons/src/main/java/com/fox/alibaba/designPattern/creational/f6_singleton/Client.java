package com.fox.alibaba.designPattern.creational.f6_singleton;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-17 10:06
* @version 1.0
*/
public class Client {
	public static void main(String[] args) {
		SingletonStaticClass instance = SingletonStaticClass.getInstance();
		System.out.println(instance.hashCode());
	}
}
