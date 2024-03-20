package com.fox.alibaba.test;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-07-28 08:10
 * @version 1.0
 */
public class StringTest {

	String str = new String("hello");
	char[] ch = { 'a', 'b', 'c' };

	public void fun(String str, char ch[]){
	     str="world";
	     ch[0]='d';
	}

	public static void main(String[] args) {
		StringTest test1 = new StringTest();
		test1.fun(test1.str, test1.ch);
		System.out.print(test1.str + " and ");
		System.out.print(test1.ch);
	}
}
