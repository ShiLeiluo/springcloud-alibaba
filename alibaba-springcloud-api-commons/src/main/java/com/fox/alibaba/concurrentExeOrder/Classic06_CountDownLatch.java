package com.fox.alibaba.concurrentExeOrder;

import java.util.concurrent.CountDownLatch;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 16:43
* @version 1.0
*/
// 使用线程的CountDownLatch(倒计数)方法
public class Classic06_CountDownLatch {
	
	// 判断线程一是否执行
	private static CountDownLatch c1 = new CountDownLatch(1);
	// 判断线程二是否执行
	private static CountDownLatch c2 = new CountDownLatch(1);
	
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			System.out.println("1. 打开冰箱");
			c1.countDown();
		});
		Thread t2 = new Thread(()->{
			
			try {
				c1.await();
				System.out.println("2. 塞入大象");
				c2.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		Thread t3 = new Thread(()->{
			try {
				c2.await();
				System.out.println("3. 关闭冰箱");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		t3.start();
		t1.start();
		t2.start();
	}
}
