package com.fox.alibaba.concurrentunsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-17 15:50
 * @version 1.0
 * Unsafe内存屏障
 * 如果你写过C或者C++，一定对内存操作不会陌生，而 Java 是不允许直接对内存进行操作的，对象内存的分配和回收都是由jvm自己实现。
 * 但是在 Unsafe 中，提供的下列接口都可以直接进行内存操作
 */
public class Unsafe01_Memory {
//	//分配新的本地空间
//	 public native long allocateMemory(long bytes);
//	 //重新调整内存空间的大小
//	 public native long reallocateMemory(long address, long bytes);
//	 //将内存设置为指定值
//	 public native void setMemory(Object o, long offset, long bytes, byte value);
//	 //内存拷贝
//	 public native void copyMemory(Object srcBase, long srcOffset,Object destBase, long destOffset,long bytes);
//	 //清除内存
//	 public native void freeMemory(long address);

	public static void main(String[] args) {
		Unsafe01_Memory mt = new Unsafe01_Memory();
		try {
			mt.fieldTest(getUnsafe());
			mt.memoryTest();

		} catch (IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void memoryTest() throws IllegalAccessException, NoSuchFieldException, SecurityException {
		int size = 4;
		Unsafe unsafe = getUnsafe();
		long addr = unsafe.allocateMemory(size);
		long addr3 = unsafe.reallocateMemory(addr, size * 2);
		System.out.println("addr: " + addr);
		System.out.println("addr3: " + addr3);
		try {
			unsafe.setMemory(null, addr, size, (byte) 1);
			for (int i = 0; i < 2; i++) {
				unsafe.copyMemory(null, addr, null, addr3 + size * i, 4);
			}
			System.out.println(unsafe.getInt(addr));
			System.out.println(unsafe.getLong(addr3));
		} finally {
			unsafe.freeMemory(addr);
			unsafe.freeMemory(addr3);
		}
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

	public void fieldTest(Unsafe unsafe) throws NoSuchFieldException {
		User user = new User();
		long fieldOffset = unsafe.objectFieldOffset(User.class.getDeclaredField("age"));
		System.out.println("offset:" + fieldOffset);
		unsafe.putInt(user, fieldOffset, 20);
		System.out.println("age:" + unsafe.getInt(user, fieldOffset));
		System.out.println("age:" + user.getAge());
	}

	private class User {
		private String userName;
		private int age;

		public User() {
		}

		public User(String userName, int age) {
			this.userName = userName;
			this.age = age;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "User{" + "userName='" + userName + '\'' + ", age=" + age + '}';
		}
	}

}
