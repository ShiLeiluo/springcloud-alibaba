package com.fox.alibaba.designPattern.creational.f6_singleton;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-05 10:58
* @version 1.0
*/
public class SingletonStaticClass {
	//1. 私有的无参构造器
	private SingletonStaticClass() {}
	
	//2. 私有的静态的内部类
	private static class SingletonStatic {
		//3. 在私有的内部类中定义私有的 最终的 静态的对象
		private final static SingletonStaticClass singletonStaticClass = new SingletonStaticClass();
	}
	//4. 公共的静态的实例方法
	public static SingletonStaticClass getInstance() {
		return SingletonStatic.singletonStaticClass;
	}
	
	//测试方法
	public static void main(String[] args) {
		//利用for循环 模拟多线程环境调用
		for (int i = 0; i < 100; i++) {
			//看hashcode的值是否一致 判断是否获取了同一个对象
			new Thread(()->{
				System.out.println("获取的hashcode是: " + SingletonStaticClass.getInstance().hashCode());
			}).start();
		}
	}
//	原理类似于饿汉式，利用JVN特性实现 JVM在加载类和内部类的时候 只会在运行的时候加载一次 从而保证线程安全和懒加载。
}
