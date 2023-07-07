package com.fox.alibaba.designPattern.creational.f6_singleton;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-05 10:45
* @version 1.0
*/
public class SingletonThreadTwo {
	// 1. 私有的静态对象
	private static SingletonThreadTwo singletonThreadTwo = null;
	
	//2. 私有的无参构造器
	private SingletonThreadTwo() {}
	//3. 公共的静态的实例方法 在if里面加上锁 synchronized 在锁块里面继续判读是否为null
	public static SingletonThreadTwo getInstnace() {
		if (singletonThreadTwo == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (SingletonThreadTwo.class) {
				if (singletonThreadTwo == null) {
					singletonThreadTwo = new SingletonThreadTwo();
				}
			}
		}
		return singletonThreadTwo;
	}
	//测试方法
	public static void main(String[] args) {
		// 利用for循环 模拟多线程环境调用
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				//看每次获取的hashcode 判断是否获取了同一个对象
				System.out.println("获取的hashcode是: " + SingletonThreadTwo.getInstnace().hashCode());
			}).start();
		}
	}
//	hashcode值一致
//	由于引入了synchronized代码块，
//	所以也引入了轻量级锁、重量级锁的概念，
//	虽然保障了线程安全，但是却失去了性能加成并且容易导致死锁，
//	所以，有没有什么办法，既能线程安全，又能保障效率呢？
}
