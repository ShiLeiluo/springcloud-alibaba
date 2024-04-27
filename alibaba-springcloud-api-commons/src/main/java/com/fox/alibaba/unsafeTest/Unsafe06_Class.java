package com.fox.alibaba.unsafeTest;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-25 08:57
 * @version 1.0
 */
public class Unsafe06_Class {
	private static Unsafe unsafe;
	static {
		// 不能直接new，会报错
		// unsafe = Unsafe.getUnsafe();
		// Unsafe类中有一个熟悉private static final Unsafe theUnsafe; 内部通过new实例化了，所以
		// 可以通过反射类获取这个属性，从而获取unsfe
		try {
			// 获取属性
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			unsafe = (Unsafe) field.get(null);

		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Unsafe06_Class c06 = new Unsafe06_Class();
		try {
			c06.staticTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Unsafe06_Class.defineTest();
	}
	private void staticTest() throws Exception {
		User user = new User();
		user.setAge(27);
		System.out.println(unsafe.shouldBeInitialized(User.class));
		Field sexField = User.class.getDeclaredField("name");
		long fieldOffset = unsafe.staticFieldOffset(sexField);
		Object fieldBase = unsafe.staticFieldBase(sexField);
		Object object = unsafe.getObject(fieldBase, fieldOffset);
		System.out.println(object);
	}
//	set JAVA_HOME=E:\2023\DEV\JDK\jdk1.8
//	set CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOMe%\lib\tools.jar;
//	set Path=%JAVA_HOME%\\bin;
	private static void defineTest() {
	     String fileName="E:\\2023\\DEV\\STS\\sts-4.16.1.RELEASE\\workspace\\alibaba-springcloud-parent\\alibaba-springcloud-api-commons\\src\\main\\java\\com\\fox\\alibaba\\unsafeTest\\User.class";
	     File file = new File(fileName);
	     try(FileInputStream fis = new FileInputStream(file)) {
	         byte[] content=new byte[(int)file.length()];
	         fis.read(content);
	         Class<?> clazz = unsafe.defineClass(null, content, 0, content.length, null, null);
	         Object o = clazz.newInstance();
	         Object age = clazz.getMethod("getAge").invoke(o);
	         System.out.println(age);
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	 }

}
