package com.fox.alibaba.leetcode150_13_graph_bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-02 16:13
* @version 1.0
*/
public class Classic095_Graph_BFS_MinMutation {

	public static void main(String[] args) {
		Classic095_Graph_BFS_MinMutation c95 = new Classic095_Graph_BFS_MinMutation();

		String startGene = "AACCGGTT";
		String endGene = "AAACGGTA";
		String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
		System.out.println(c95.minMutation(startGene, endGene, bank));
	}
	
	public int minMutation(String startGene, String endGene, String[] bank){
		
		if (startGene.equals(endGene)) {
			return 0;
		}

		
		Set<String> bankSet = new HashSet<>();
		Set<String> visited = new HashSet<>();
		
		for (int i = 0; i < bank.length; i++) {
			bankSet.add(bank[i]);
		}
		if (!bankSet.contains(endGene)) {
			return -1;
		}
		Queue<String> queue = new LinkedList<>();
		
		queue.offer(startGene);
		visited.add(startGene);
		int steps = 1;
		
		char[] keys = {'A','C','G','T'};
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				String curr = queue.poll();
				for (int j = 0; j < 8; j++) {
					for (char c : keys) {
						if (c == curr.charAt(j)) {
							continue;
						}
						StringBuilder sb = new StringBuilder(curr);
						sb.setCharAt(j, c);
						String next = sb.toString();
						if (!visited.contains(next) && bankSet.contains(next)) {
							if (next.equals(endGene)) {
								return steps;
							}
							visited.add(next);
							queue.offer(next);
						}
					}
				}
				
//				size--;
			}
			steps++;
		}
		
		return -1;
		
	}
}
