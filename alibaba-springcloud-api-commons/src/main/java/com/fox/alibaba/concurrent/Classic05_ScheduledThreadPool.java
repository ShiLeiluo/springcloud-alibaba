package com.fox.alibaba.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-12 16:53
* @version 1.0
*/
public class Classic05_ScheduledThreadPool {
	public static void main(String[] args) {
		Classic05_ScheduledThreadPool scheduledThread = new Classic05_ScheduledThreadPool();
		scheduledThread.runTask();
	}
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public void runTask() {
		
		// 看起来是直接new一个接口，实际上是匿名内部类
		// 因为接口不能实例化，new Runnable（）是一个实现接口Runnable的类的对象，后面的run方法是该类里实现的方法，这就是匿名内部类的写法
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + " "+ task());
			}
		};
		
		ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
		
		// 一次性任务
		ScheduledFuture<?> schedule = executor.schedule(r, 5, TimeUnit.SECONDS);
		// 初始延迟0秒，之后每隔1秒执行一次  
		executor.scheduleAtFixedRate(r, 0, 5, TimeUnit.SECONDS);
		// 初始延迟0秒，之后执行完3秒后再执行  
		executor.scheduleAtFixedRate(r, 0, 3, TimeUnit.SECONDS);
		schedule.cancel(false);
		
	}
	
	private static String task() {
		
		String msg = "运行定时任务";
		return df.format(new Date()) + " " + msg;
	}
}

