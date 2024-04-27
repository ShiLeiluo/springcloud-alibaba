package com.fox.alibaba.concurrentExeOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-25 08:21
 * @version 1.0
 */
public class Classic06_Executors {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(1);

		Thread t1 = new Thread() {

			@Override
			public void run() {
				System.out.println("1. 打开冰箱");

			}
		};

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("2. 塞入大象");

			}

		});

		Thread t3 = new Thread(() -> {
			System.out.println("3. 关闭冰箱");
		});
		
		
		for (int i = 0; i < 10; i++) {
			executor.execute(t1);
			executor.execute(t2);
			executor.execute(t3);
		}
		

		executor.shutdown();
	}
}
