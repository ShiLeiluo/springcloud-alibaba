package com.fox.alibaba.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-06 16:38
* @version 1.0
*/
public class Classic03_Callable_Interface implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "Hello, i am running.";
	}
	public static void main(String[] args) {
		Classic03_Callable_Interface c03 = new Classic03_Callable_Interface();
		
		//创建异步任务
		FutureTask<String> task = new FutureTask<>(c03);
		
		//启动线程
		Thread t = new Thread(task);
		t.start();
		
		try {
			//等待执行完成，并获取返回结果
			String res = task.get();
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
