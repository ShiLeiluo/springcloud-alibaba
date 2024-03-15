package com.fox.alibaba.concurrent;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-06 14:08
* @version 1.0
*/
public class Classic01_Thread_Class extends Thread {
	public static void main(String[] args) {
		//创建MyThread对象
		Classic01_Thread_Class t1 = new Classic01_Thread_Class();
		Classic01_Thread_Class t2 = new Classic01_Thread_Class();
		Classic01_Thread_Class t3 = new Classic01_Thread_Class();
		
		//设置线程的名字
		t1.setName("鲁班");
		t2.setName("刘备");
		t3.setName("亚瑟");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
		
		Classic01_Thread_Class c01 = new Classic01_Thread_Class();
		c01.setName("张飞");
		Thread c01Thread = new Thread(c01, "张飞");
		
		c01Thread.start();
	}
	
//	getName()=当前Thread实例名称
//	Thread.current.currentThread().getName()=当前线程名称
	
	@Override //重写 run 方法。
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("线程:"+Thread.currentThread().getName()+", 实例:"+getName()+":打了"+i+"个小兵.");
		}
	}

}
