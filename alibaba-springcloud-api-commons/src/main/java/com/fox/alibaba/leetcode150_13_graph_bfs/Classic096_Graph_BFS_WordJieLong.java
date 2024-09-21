package com.fox.alibaba.leetcode150_13_graph_bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-06 09:06
* @version 1.0
*/
public class Classic096_Graph_BFS_WordJieLong {
	public static void main(String[] args) {
		Classic096_Graph_BFS_WordJieLong c96 = new Classic096_Graph_BFS_WordJieLong();
		
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");wordList.add("dot");
		wordList.add("dog");wordList.add("lot");
		wordList.add("log");wordList.add("cog");
		
		System.out.println(c96.ladderLength(beginWord, endWord, wordList));
				
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		
		if (!wordList.contains(endWord)) {
			return 0;
		}
		char[] dictionary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		
		Set<String> visited = new HashSet<>();
		
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int step = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();

				for (int j = 0; j < curr.length(); j++) {
					
					for (char c : dictionary) {
						if (c == curr.charAt(j)) {
							continue;
						}
						StringBuilder sb = new StringBuilder(curr);
						sb.setCharAt(j, c);
						String next = sb.toString();
						if (wordList.contains(next) && !visited.contains(next)) {
							if (next.equals(endWord)) {
								return step;
							}
 							visited.add(next);
							queue.offer(next);
						}
					}
				}
			}
			
			step++;
		}
		
		
		return 0;
		
	}
}
