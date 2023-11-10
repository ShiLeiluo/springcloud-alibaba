package com.fox.alibaba.notes;


/**
* @author F1337248 ShiLeiluo
* @date 2023-08-30 15:50
* @version 1.0
*/
public class A_Join {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(test1());
//		Thread t2 = new Thread(test2());
//		Thread t3 = new Thread(test3());
		
		t1.start();
//		t2.start();
//		t3.start();
		
	}
	
	public static Runnable test1() {
		Thread t3 = new Thread(test3());
		Thread t2 = new Thread(test2());
		t3.start();
		t2.start();
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					t3.join();
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("test1");
			}
		};
		return runnable;
	}
	public static Runnable test2() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("test2");
			}
		};
		return runnable;
	}
	public static Runnable test3() {
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("test3");
			}
		};
		return runnable;
	}
}
