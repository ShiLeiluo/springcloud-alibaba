package com.fox.alibaba.concurrentunsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-23 14:08
* @version 1.0
*/
public class Unsafe04_CAS {
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
	private volatile int a;
	 public static void main(String[] args){
		 Unsafe04_CAS casTest=new Unsafe04_CAS();
	     new Thread(()->{
	         for (int i = 1; i < 5; i++) {
	             casTest.increment(i);
	             System.out.print(casTest.a+" ");
	         }
	     }).start();
	     new Thread(()->{
	         for (int i = 5 ; i <10 ; i++) {
	             casTest.increment(i);
	             System.out.print(casTest.a+" ");
	         }
	     }).start();
	 }
//	 public final native boolean compareAndSwapInt(Object o, long offset,int expected,int x);

	 private void increment(int x){
	     while (true){
	         try {
	             long fieldOffset = unsafe.objectFieldOffset(Unsafe04_CAS.class.getDeclaredField("a"));
	             if (unsafe.compareAndSwapInt(this,fieldOffset,x-1,x))
	                 break;
	         } catch (NoSuchFieldException e) {
	             e.printStackTrace();
	         }
	     }
	 }
}
