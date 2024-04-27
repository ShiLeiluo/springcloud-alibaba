package com.fox.alibaba.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-25 08:44
* @version 1.0
*/
public class Classic07_IO_ThreadPoolExecutor {
	private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
	private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
	private static final int MAX_POOL_SIZE = CPU_COUNT * 2;

	private static final ThreadPoolExecutor exec = new ThreadPoolExecutor(
			CORE_POOL_SIZE,                                       // 核心线程数
			MAX_POOL_SIZE,                                        // 最大线程数
			10L,						                          // 超出核心线程数的线程最大存活时间
			TimeUnit.SECONDS,                                     // 最大存活时间的单位
			new LinkedBlockingQueue<>(1000)                       // 存放任务的阻塞队列
	);

	public static void main(String[] args) {
		Callable<Double> task = () -> Math.random() * 100;

		List<Future<Double>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(task));
		}

		for (Future<Double> result : results) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		exec.shutdown();
	}
}
