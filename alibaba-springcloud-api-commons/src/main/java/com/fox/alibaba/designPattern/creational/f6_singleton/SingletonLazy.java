package com.fox.alibaba.designPattern.creational.f6_singleton;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-05 10:17
* @version 1.0
*/
public class SingletonLazy {
	// 1. 私有的静态对象 先不new 默认为null
	private static SingletonLazy singletonLazy = null;
	// 2. 私有的无参构造器
	private SingletonLazy() {}
	// 3. 公共的静态方法
	public static SingletonLazy getInstance() throws InterruptedException {
		if (singletonLazy == null) {
			Thread.sleep(1000);
			singletonLazy = new SingletonLazy();
			
		}
		return singletonLazy;
	}
	// 测试方法
	public static void main(String[] args) {
		
		//利用for循环 模拟多线程环境调用
		for (int i = 0; i < 100; i++) {
			//看每次对象的hashcode是否一致 判断是否获取了同一个对象
			new Thread(()->{
				try {
					System.out.println("获取的hashcode是: " + SingletonLazy.getInstance().hashCode());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		}
		
	}
	//hashcode不一致
	//懒汉模式在多线程并发获取单例类时，存在线程安全的问题，那么既然存在线程安全问题，我们怎么去改善这个问题呢？请看线程锁模式。

}
