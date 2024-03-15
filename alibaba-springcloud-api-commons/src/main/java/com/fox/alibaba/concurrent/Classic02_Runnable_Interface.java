package com.fox.alibaba.concurrent;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-06 15:34
* @version 1.0
*/
public class Classic02_Runnable_Interface implements Runnable {

	public static void main(String[] args) {
		//创建MyRunnable类
		Classic02_Runnable_Interface c02 = new Classic02_Runnable_Interface();
		//创建Thread类的有参构造, 并设置线程名
		Thread t1 = new Thread(c02, "张飞");
		Thread t2 = new Thread(c02, "貂蝉");
		Thread t3 = new Thread(c02, "吕布");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			try {//sleep会发生异常要显示处理
				Thread.sleep(20);//暂停20毫秒
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":打了"+i+"个小兵.");
		}
	}

}
