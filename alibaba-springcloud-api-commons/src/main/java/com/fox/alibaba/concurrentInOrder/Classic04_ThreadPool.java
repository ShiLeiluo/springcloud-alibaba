package com.fox.alibaba.concurrentInOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-15 15:15
* @version 1.0
*/
// 使用线程的线程池方法
public class Classic04_ThreadPool {
	
	// 返回JAVA进程可用核数
	private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
	private static final int CORE_POOL_SIZE = CPU_COUNT * 2;
	private static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1;
	
	private static ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3));
	public static void main(String[] args) {
		System.out.println("CPU_COUNT: " + CPU_COUNT);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("1. 打开冰箱");
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("2. 塞入大象");
			}
			
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("3. 关上冰箱");
			}
			
		});

		executorService.execute(t1);
		executorService.execute(t2);
		executorService.execute(t3);
		
		// shutdown()：启动线程池的关闭序列，不再接受新的任务提交，但已提交的任务会继续执行。
		// shutdownNow()：尝试停止所有正在执行的任务，停止处理正在等待的任务，并返回等待执行的任务列表。
		executorService.shutdown();
	}
}
