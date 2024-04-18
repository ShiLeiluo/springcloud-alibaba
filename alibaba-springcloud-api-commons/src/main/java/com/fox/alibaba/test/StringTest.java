package com.fox.alibaba.test;

import java.util.LinkedList;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-07-28 08:10
 * @version 1.0
 */
public class StringTest {



	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.offer(1);
		list.offer(2);
		System.out.println(list.peek());
		list.push(3);
		System.out.println(list.peek());
		
		
		StringBuilder sb = new StringBuilder("test");
		System.out.println(sb.substring(1, 3));
	}
}
