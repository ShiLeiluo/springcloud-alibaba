package com.fox.alibaba.concurrentForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveTask;


/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-29 18:15
 * @version 1.0
 */
public class ForkJoinDemo {
//	private static final Logger logger = LoggerFactory.getLogger(ForkJoinDemo.class);
	// 1. 运行入口
	public static void main(String[] args) {
		int n = 20;

		// 为了追踪子线程名称，需要重写 ForkJoinWorkerThreadFactory 的方法
		final ForkJoinPool.ForkJoinWorkerThreadFactory factory = pool -> {
			final ForkJoinWorkerThread worker = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(pool);
			worker.setName("my-thread" + worker.getPoolIndex());
			return worker;
		};

		// 创建分治任务线程池，可以追踪到线程名称
		ForkJoinPool forkJoinPool = new ForkJoinPool(4, factory, null, false);

		// 快速创建 ForkJoinPool 方法
		// ForkJoinPool forkJoinPool = new ForkJoinPool(4);

		// 创建分治任务
		Fibonacci fibonacci = new Fibonacci(n);

		// 调用 invoke 方法启动分治任务
		Integer result = forkJoinPool.invoke(fibonacci);
		System.out.println("Fibonacci "+n+" 的结果是 "+result);
	}
}

// 2. 定义拆分任务，写好拆分逻辑 
class Fibonacci extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int n;

	Fibonacci(int n) {
		this.n = n;
	}

	@Override
	public Integer compute() {
		// 和递归类似，定义可计算的最小单元
		if (n <= 1) {
			return n;
		}
		// 想查看子线程名称输出的可以打开下面注释
		// log.info(Thread.currentThread().getName());

		Fibonacci f1 = new Fibonacci(n - 1);
		// 拆分成子任务
		f1.fork();
		Fibonacci f2 = new Fibonacci(n - 2);
		// f1.join 等待子任务执行结果
		return f2.compute() + f1.join();
	}
}