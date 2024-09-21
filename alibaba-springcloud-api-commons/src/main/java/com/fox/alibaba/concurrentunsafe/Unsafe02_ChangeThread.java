package com.fox.alibaba.concurrentunsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-18 15:21
 * @version 1.0
 * Unsafe内存屏障: 实现volatile功能
 */

public class Unsafe02_ChangeThread implements Runnable {
//	//禁止读操作重排序
//	 public native void loadFence();
//	 //禁止写操作重排序
//	 public native void storeFence();
//	 //禁止读、写操作重排序
//	 public native void fullFence();

	public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, SecurityException {
		Unsafe02_ChangeThread changeThread = new Unsafe02_ChangeThread();
		new Thread(changeThread).start();
		while (true) {
			boolean flag = changeThread.isFlag();
//			而如果删掉上面代码中的loadFence方法，那么主线程将无法感知到flag发生的变化，会一直在while中循环。
			getUnsafe().loadFence(); // 加入读内存屏障
			if (flag) {
				System.out.println("detected flag changed");
				break;
			}
		}
		System.out.println("main thread end");
	}

	/** volatile **/
	boolean flag = false;
	public boolean isFlag() {
		return flag;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("subThread change flag to:" + flag);
		flag = true;
	}
	// 利用反射获得 Unsafe 类中已经实例化完成的单例对象
	public static Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException, SecurityException {
		Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
		// Field unsafeField = Unsafe.class.getDeclaredFields()[0]; //也可以这样，作用相同
//		由于JDK的安全检查耗时较多.所以通过setAccessible(true)的方式关闭安全检查就可以达到提升反射速度的目的 
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		return unsafe;
	}
}
