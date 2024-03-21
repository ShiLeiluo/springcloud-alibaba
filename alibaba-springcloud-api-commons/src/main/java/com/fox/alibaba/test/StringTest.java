package com.fox.alibaba.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-07-28 08:10
 * @version 1.0
 */
public class StringTest {


	public void fun(){
		Deque<String> stackDeque = new ArrayDeque<>();
		stackDeque.push("a");
		stackDeque.push("b");
		stackDeque.push("c");
		change(stackDeque);
		System.out.println("--------------");
		while (!stackDeque.isEmpty()) {
			System.out.println(stackDeque.pop());
			
		}
	}
	private void change(Deque<String> stackDeque) {
		stackDeque.pop();
//		while (!stackDeque.isEmpty()) {
//			System.out.println(stackDeque.pop());
//			
//		}
	}

	public static void main(String[] args) {
		StringTest test1 = new StringTest();
		test1.fun();
	}
}
