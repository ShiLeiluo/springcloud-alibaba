package com.fox.alibaba.notes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
* @author F1337248 ShiLeiluo
* @date 2023-08-30 16:59
* @version 1.0
*/
public class A_CompletabletableFuture {
	public static void main(String[] args) {
		Thread t1 = new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"执行t1");
		}, "t1");
//		Thread t2 = new Thread(()->{
//			System.out.println(Thread.currentThread().getName()+"执行");
//		}, "t2");
//		Thread t3 = new Thread(()->{
//			System.out.println(Thread.currentThread().getName()+"执行");
//		}, "t3");
		


		CompletableFuture<Void> c1 = CompletableFuture.runAsync(t1);
		CompletableFuture<Void> c2 = c1.thenRun(()->{
			System.out.println(Thread.currentThread().getName()+"执行c2");
		});
		CompletableFuture<Void> c3 = c2.thenRun(()->{
			System.out.println(Thread.currentThread().getName()+"执行c3");
		});
		try {
			c3.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
