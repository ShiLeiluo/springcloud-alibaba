package com.fox.alibaba.test;

import java.util.LinkedList;
import java.util.Queue;


/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 09:18
* @version 1.0
*/
public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		System.out.println(queue.peek());
	}
}
