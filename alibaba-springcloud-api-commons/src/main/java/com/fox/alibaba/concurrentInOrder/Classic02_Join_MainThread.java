package com.fox.alibaba.concurrentInOrder;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 14:54
* @version 1.0
*/
// 使用主线程的join方法
public class Classic02_Join_MainThread {
	public static void main(String[] args) throws InterruptedException {
		final Thread t1 = new Thread(()->{
			
			System.out.println("1. 打开冰箱");
		});
		final Thread t2 = new Thread(()->{
			
			System.out.println("2. 塞入大象");
		});
		final Thread t3 = new Thread(()->{
			
			System.out.println("3. 关上冰箱");
		});
		//在父进程调用子进程的join()方法后，父进程需要等待子进程运行完再继续运行。
		// 将执行线程都加入到主线程
		// 主线程中使用join()来实现对线程的阻塞。
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();
		
		t3.start();
		
	}
}
