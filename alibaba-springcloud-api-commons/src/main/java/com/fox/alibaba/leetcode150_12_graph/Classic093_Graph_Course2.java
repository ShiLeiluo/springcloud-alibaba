package com.fox.alibaba.leetcode150_12_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-26 16:01
* @version 1.0
*/
public class Classic093_Graph_Course2 {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] preprequisites = {};
		
		Classic093_Graph_Course2 c93 = new Classic093_Graph_Course2();
		
		System.out.println(Arrays.toString(c93.findOrder(numCourses, preprequisites)));
	}
	// 入度: in-degree 出度: out-degree
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int rows = prerequisites.length;
		
		// 1. 找到所有课程的入度 inDegree, 需要依赖课程的数量
		//    被依赖课程为key, 依赖它的课程为 value
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] inDegree = new int[numCourses];
		//
		
		for (int i = 0; i < rows; i++) {
			inDegree[prerequisites[i][0]] += 1;
			map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
			map.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		
		// 2. 找到入度 in-degree 为 0 的节点, 加入队列
		
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		int path[] = new int[numCourses];
		int idx = 0;
		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			path[idx++] = poll;
			for (Integer course : map.getOrDefault(poll, new ArrayList<>())) {
				inDegree[course] -= 1;
				if (inDegree[course] == 0) {
					queue.offer(course);
				}
			}
		}
		
		if (idx == numCourses) {
			return path;
		}
		
		return new int[0];
		
	}
}
