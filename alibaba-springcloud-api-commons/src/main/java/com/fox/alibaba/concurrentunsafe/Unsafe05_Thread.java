package com.fox.alibaba.concurrentunsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import sun.misc.Unsafe;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-24 19:27
* @version 1.0
*/
public class Unsafe05_Thread {
	
	private static Unsafe unsafe;
	
	static {
        //不能直接new，会报错
        //unsafe = Unsafe.getUnsafe();
        //Unsafe类中有一个熟悉private static final Unsafe theUnsafe; 内部通过new实例化了，所以
        // 可以通过反射类获取这个属性，从而获取unsfe
        try {
            //获取属性
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
	     Thread mainThread = Thread.currentThread();
	     new Thread(()->{
	         try {
	             TimeUnit.SECONDS.sleep(5);
	             System.out.println("subThread try to unpark mainThread/子线程尝试取消驻留主线程");
	             unsafe.unpark(mainThread);
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	     }).start();

	     System.out.println("park main mainThread/驻留主线程");
	     unsafe.park(false,0L);
	     System.out.println("unpark mainThread success/取消驻留主线程成功");
	 }

}
