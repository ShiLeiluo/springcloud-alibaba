package com.fox.alibaba.concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-25 08:41
* @version 1.0
*/
public class Classic06_CPU_ThreadPoolExecutor {
	private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
	private static final int CORE_POOL_SIZE = 2 * CPU_COUNT;
	private static final int MAX_POOL_SIZE = 2 * CPU_COUNT + 1;

	private static final ThreadPoolExecutor exec = new ThreadPoolExecutor(
			CORE_POOL_SIZE,                                       // 核心线程数
			MAX_POOL_SIZE,                                        // 最大线程数
			60L,						                          // 超出核心线程数的线程最大存活时间
			TimeUnit.SECONDS,                                  	  // 最大存活时间的单位
			new LinkedBlockingQueue<>(1000)                       // 存放任务的阻塞队列
	);

	public static void main(String[] args) {
		while (true) {
			Runnable request = () -> System.out.println("Request handled by " + Thread.currentThread().getName());

			exec.execute(request);
		}
	}
}
