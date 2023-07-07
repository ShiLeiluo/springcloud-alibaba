package com.fox.alibaba.designPattern.creational.f6_singleton;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-05 10:27
* @version 1.0
*/
public class SingletonThread {
	// 1. 私有的静态对象 
	private static SingletonThread singletonThread = null;
	
	// 2. 私有的无参构造器
	private SingletonThread() {}
	
	// 3. 公共的静态的实例方法 在 if 里面加上锁synchronize修饰
	
	public static SingletonThread getInstance() {
		if (singletonThread == null) {
			synchronized (SingletonThread.class) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				singletonThread = new SingletonThread();
			}
		}
		return singletonThread;
	}
	
	//测试方法
	public static void main(String[] args) {
		//利用for循环 模拟多线程环境使用
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				System.out.println("获取的hashcode是: "+ SingletonThread.getInstance().hashCode());
			}).start();
		}
	}
	// 结果hashcode的值不一致 在执行到synchronized代码块的时候 有线程已经获取到了对象 从而导致获取的对象不一致
}
