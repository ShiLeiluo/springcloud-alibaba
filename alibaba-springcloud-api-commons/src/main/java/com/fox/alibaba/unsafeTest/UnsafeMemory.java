package com.fox.alibaba.unsafeTest;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-17 15:50
 * @version 1.0
 */
public class UnsafeMemory {

	public static void main(String[] args) {
		UnsafeMemory mt = new UnsafeMemory();
		try {
			mt.memoryTest();
			mt.fieldTest(getUnsafe());
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
