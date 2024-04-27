package com.fox.alibaba.concurrentExeOrder;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-15 16:49
 * @version 1.0
 */
// 使用线程的CyclicBarrier(回环栅栏)方法
public class Classic07_CyclicBarrier {
	private static CyclicBarrier barrier1 = new CyclicBarrier(2);
	private static CyclicBarrier barrier2 = new CyclicBarrier(2);

	// 所有线程都调用了await()方法后，计数器变为0，屏障就被克服了，每个线程继续执行它们之后的任务。
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {

			try {
				System.out.println("1. 打开冰箱");
				barrier1.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {

			try {
				barrier1.await();
				System.out.println("2. 塞入大象");
				barrier2.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(() -> {

			try {
				barrier2.await();
				System.out.println("3. 关闭冰箱");
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t3.start();
		t1.start();
		t2.start();
	}
}
