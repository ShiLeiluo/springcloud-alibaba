package com.fox.alibaba.test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-02-23 17:22
 * @version 1.0
 */
class Student {
	private String name;
	private int chineseScore;
	private int mathScore;

	public Student(String name, int chineseScore, int mathScore) {
		this.name = name;
		this.chineseScore = chineseScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getChineseScore() {
		return chineseScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", 总成绩=" + (chineseScore + mathScore) + '}';
	}
}

public class PriorityQueueComparatorExample implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		// 比较总成绩
		return Integer.compare(s2.getChineseScore() + s2.getMathScore(), s1.getChineseScore() + s1.getMathScore());
	}

	public static void main(String[] args) {
		// 创建一个按照总成绩排序的优先级队列
		PriorityQueue<Student> queue = new PriorityQueue<>(new PriorityQueueComparatorExample());

		// 添加元素
		queue.offer(new Student("王二", 80, 90));
		System.out.println(queue);
		queue.offer(new Student("陈清扬", 95, 95));
		System.out.println(queue);
		queue.offer(new Student("test", 95, 95));
		System.out.println(queue);
		queue.offer(new Student("小驼铃", 90, 95));
		System.out.println(queue);
		queue.offer(new Student("沉默", 90, 80));
		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
