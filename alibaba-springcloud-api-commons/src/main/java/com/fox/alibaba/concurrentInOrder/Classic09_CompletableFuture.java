package com.fox.alibaba.concurrentInOrder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 17:42
* @version 1.0
*/
//1.thenRun(Runnable action): 沿用上一个任务的线程池
//2.thenRunAsync(Runnable action): 使用公用的 ForkJoinPool 线程池(不推荐使用公用线程池)
//3.thenRunAsync(Runnable action,Executor executor): 使用自定义线程池(推荐)
public class Classic09_CompletableFuture {
	private static ExecutorService executor = Executors.newFixedThreadPool(1);
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Void> t1 = CompletableFuture.runAsync(()->{
			System.out.println("1. 打开冰箱");
		}, executor);
		CompletableFuture<Void> t2 = t1.thenRunAsync(()->{
			System.out.println("2. 塞入大象");
		});
		CompletableFuture<Void> t3 = t2.thenRunAsync(()->{
			System.out.println("3. 关闭冰箱");
		});
		// get(): 获取异步任务的结果，如果任务尚未完成，则阻塞等待。
		CompletableFuture.allOf(t1, t2, t3).get();
		executor.shutdown();
	}
}
