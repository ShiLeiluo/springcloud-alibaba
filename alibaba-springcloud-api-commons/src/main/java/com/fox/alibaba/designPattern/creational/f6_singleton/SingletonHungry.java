package com.fox.alibaba.designPattern.creational.f6_singleton;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-05 10:01
* @version 1.0
*/
public class SingletonHungry {
	//1. 私有静态类的最终的对象
	private static final SingletonHungry single = new SingletonHungry();
	//2. 私有的无参构造函数
	private SingletonHungry() {}
	//3. 公共的静态实例方法
	public static SingletonHungry getInstance() {
		return single;
	}
	//测试方法
	public static void main(String[] args) {
		//利用for循环 模拟多线程循环调用
		for (int i = 0; i < 100; i++) {
			new Thread(()->{
				//看每次获取的hashcode是否一致 判断是否获取了同一个对象
				System.out.println("获取的hashcode是: "+SingletonHungry.getInstance().hashCode());
			}).start();;
		}
//		饿汉模式
//		 代码结构如下：
//
//		1. 私有的静态的 最终的 对象 直接new
//		2. 私有的 无参构造方法
//		3. 共有的 静态的 实例方法
//		饿汉模式是单例模式中常用的写法之一，主要的特点是在定义对象的时候就直接new一个对象
//		*********************************************************
//		可以看到执行结果是一致的，这种饿汉写法一般在实际项目中应用的也是最多的，
//
//		优点：这种写法比较简单，就是在类装载的时候就完成实例化，避免了线程同步问题。
//
//		缺点：但是因为在指定对象时就进行初始化，在类比较大的时候，也会造成一定的资源消耗。
	}
}
