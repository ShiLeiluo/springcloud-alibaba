package com.fox.alibaba.concurrentunsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-25 09:30
 * @version 1.0
 */
public class Unsafe07_System {

	private static Unsafe unsafe;
	static {
		try {
			// 获取属性
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);

		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	private void systemTest() {
		System.out.println(unsafe.addressSize());
		System.out.println(unsafe.pageSize());
		System.out.println(Runtime.getRuntime().availableProcessors());

	}

	public static void main(String[] args) {
		Unsafe07_System c07 = new Unsafe07_System();
		c07.systemTest();
	}

}
