package com.fox.alibaba.concurrentExeOrder;

import java.util.concurrent.locks.LockSupport;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-24 19:10
* @version 1.0
*/
// park、unpark是通过我们的老朋友Unsafe类实现的
public class Classic10_LockSupport {

	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread();
		
		Thread t1 = new Thread() {
			
			@Override
			public void run() {
				System.out.println("1. 打开冰箱");
				LockSupport.unpark(mainThread);
			}
		};
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("2. 塞入大象");
				LockSupport.unpark(mainThread);
			}
			
		});
		
	
		Thread t3 = new Thread(()->{
			System.out.println("3. 关闭冰箱");
		});
		
		t1.start();
		
		LockSupport.park(mainThread);
		t2.start();
		LockSupport.park(mainThread);
		t3.start();
	}
}
