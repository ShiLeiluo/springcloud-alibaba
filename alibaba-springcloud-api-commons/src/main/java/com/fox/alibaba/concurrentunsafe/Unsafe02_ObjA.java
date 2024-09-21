package com.fox.alibaba.concurrentunsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-18 15:51
* @version 1.0
* Unsafe对象操作
*/
public class Unsafe02_ObjA {
//	//在对象的指定偏移地址获取一个对象引用
//	 public native Object getObject(Object o, long offset);
//	 //在对象指定偏移地址写入一个对象引用
//	 public native void putObject(Object o, long offset, Object x);
//	//在对象的指定偏移地址处读取一个int值，支持volatile load语义
//	 public native int getIntVolatile(Object o, long offset);
//	 //在对象指定偏移地址处写入一个int，支持volatile store语义
//	 public native void putIntVolatile(Object o, long offset, int x);
//	 public native void putOrderedObject(Object o, long offset, Object x);
//	 public native void putOrderedInt(Object o, long offset, int x);
//	 public native void putOrderedLong(Object o, long offset, long x);

	public static void main(String[] args) throws Exception {
		Unsafe02_ObjA a = new Unsafe02_ObjA();
		a.objTest();
	}
	
//	打印结果分别为 1、1、0，说明通过allocateInstance方法创建对象过程中，不会调用类的构造方法。
//
//	使用这种方式创建对象时，只用到了Class对象，所以说如果想要跳过对象的初始化阶段或者跳过构造器的安全检查，就可以使用这种方法。
//
//	在上面的例子中，如果将 A 类的构造方法改为private类型，将无法通过构造方法和反射创建对象，但allocateInstance方法仍然有效。

	public void objTest() throws Exception{
		Unsafe02_ObjA a1=new Unsafe02_ObjA();
		System.out.println(a1.getB());
		Unsafe02_ObjA a2 = Unsafe02_ObjA.class.newInstance();
	    System.out.println(a2.getB());
	    Unsafe02_ObjA a3= (Unsafe02_ObjA) getUnsafe().allocateInstance(Unsafe02_ObjA.class);
	    System.out.println(a3.getB());
	 }

    private int b;
    public Unsafe02_ObjA(){
        this.b =1;
    }
    public int getB() {
    	return b;
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
