package com.fox.alibaba.notes;

import java.util.concurrent.Semaphore;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-08-30 16:45
 * @version 1.0
 */
public class A_Semaphore {
	public static void main(String[] args) throws InterruptedException {
		Semaphore sem1 = new Semaphore(1);
		Semaphore sem2 = new Semaphore(1);

		sem1.acquire();

		Thread t1 = new Thread(() -> {
			System.out.println("T1 is running");
			sem1.release();
		});
		sem2.acquire();
		Thread t2 = new Thread(() -> {
			try {
				sem1.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("T2 is running");
			sem2.release();
		});
		
		Thread t3 = new Thread(() -> {
			try {
				sem2.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("T3 is running");
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
