package com.fox.alibaba.unsafeTest;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-19 14:49
* @version 1.0
*/
public class Unsafe03_Array {
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
		Unsafe03_Array c3 = new Unsafe03_Array();
		try {
			c3.arrayTest();
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	private void arrayTest() throws IllegalAccessException, NoSuchFieldException, SecurityException {
	     String[] array=new String[]{"str1str1str","str2","str3"};
	     int baseOffset = unsafe.arrayBaseOffset(String[].class);
	     System.out.println("baseOffset: "+baseOffset);
	     int scale = unsafe.arrayIndexScale(String[].class);
	     System.out.println("scale: "+scale);

	     for (int i = 0; i < array.length; i++) {
	         int offset=baseOffset+scale*i;
	         System.out.println(offset+" : "+unsafe.getObject(array,offset));
	     }
	 }

}
