package com.fox.alibaba.concurrentInOrder;

import java.util.concurrent.Semaphore;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-15 17:13
 * @version 1.0
 */
public class Classic08_Sephmore {
	private static Semaphore semaphore1 = new Semaphore(1);
	private static Semaphore semaphore2 = new Semaphore(0);
	private static Semaphore semaphore3 = new Semaphore(0);

	
	// acquire(), release() 
	// acquire(): 信号量-1
	// release(): 信号量+1
	public static void main(String[] args) {
		Thread t1 = new Thread() {
			
			@Override
			public void run() {
				try {
					semaphore1.acquire();
					System.out.println("1. 打开冰箱");
					semaphore2.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		
		Thread t2 = new Thread(()->{
			try {
				semaphore2.acquire();
				System.out.println("2. 塞入大象");
				semaphore3.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(()->{
			try {
				semaphore3.acquire();
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
