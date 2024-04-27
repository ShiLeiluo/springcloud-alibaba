package com.fox.alibaba.concurrentExeOrder;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 13:57
* @version 1.0
*/
// 使用线程的join方法
public class Classic01_Join_ExecutionThread {
	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("1. 打开冰箱");
			}
		});
		
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					t1.join();
					System.out.println("2. 塞入大象");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}; 
		Thread t2 = new Thread(r2);
		
		Thread t3 = new Thread(()->{
			try {
				t2.join();
				System.out.println("3. 关上冰箱");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t2.start();
		t3.start();
		t1.start();
	}
}
