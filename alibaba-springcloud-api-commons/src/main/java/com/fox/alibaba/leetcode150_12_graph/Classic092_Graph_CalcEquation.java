package com.fox.alibaba.leetcode150_12_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-24 10:54
* @version 1.0
*/
public class Classic092_Graph_CalcEquation {
	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		ArrayList<String> e1 = new ArrayList<>();
		ArrayList<String> e2 = new ArrayList<>();
		ArrayList<String> e3 = new ArrayList<>();
		e1.add("a");e1.add("b");
		e2.add("b");e2.add("c");
		e3.add("bc");e3.add("cd");
		equations.add(e1);
		equations.add(e2);
		equations.add(e3);

		
		double[] values = {1.5,2.5,5.0};
		
		List<List<String>> queries = new ArrayList<>();
		ArrayList<String> q1 = new ArrayList<>();
		ArrayList<String> q2 = new ArrayList<>();
		ArrayList<String> q3 = new ArrayList<>();
		ArrayList<String> q4 = new ArrayList<>();
		q1.add("a");q1.add("c");
		q2.add("c");q2.add("b");
		q3.add("bc");q3.add("cd");
		q4.add("cd");q4.add("bc");
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		queries.add(q4);
		
		Classic092_Graph_CalcEquation c92 = new Classic092_Graph_CalcEquation();
		double[] ans = c92.calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(ans));
		
	}
	
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		
		// 构建储存变量所构成的图结构
		Map<String, Map<String, Double>> graph = new HashMap<>();
		int n = equations.size();
		for (int i = 0; i < n; i++) {
			String s = equations.get(i).get(0);
			String e = equations.get(i).get(1);
			double v = values[i];
			
			if (!graph.containsKey(s)) {
				graph.put(s, new HashMap<>());
			}
			if (!graph.containsKey(e)) {
				graph.put(e, new HashMap<>());
			}
			
			graph.get(s).put(e, v); 			// 生成一条s指向e，权重为v的路径，表示 s / e = v
			graph.get(e).put(s, 1 / v); 		// 生成一条e指向s，权重为v的路径，表示 e / s = 1 / v
			graph.get(s).put(s, 1.0); 			// 生成一个指向自己、权重为1的路径，表示自己除自己等于1
			graph.get(e).put(e, 1.0); 			
		}
		
		Queue<NodeData> queue = new LinkedList<>();
		int m = queries.size();
		double[] ans = new double[m];
		Arrays.fill(ans, -1.0);
		Set<String> visited;
		
		for (int i = 0; i < m; i++) {
			String qs = queries.get(i).get(0);
			String qe = queries.get(i).get(1);
			
			if (!graph.containsKey(qs) || !graph.containsKey(qe)) {
				continue;
			}
			visited = new HashSet<>();
			queue.offer(new NodeData(qs, 1.0));
			visited.add(qs);
			
			while(!queue.isEmpty()) {
				NodeData poll = queue.poll();
				for (Map.Entry<String, Double> entry : graph.get(poll.var).entrySet()) {
					String neighbor = entry.getKey();
					double weight = entry.getValue();
					
					if (qe.equals(neighbor)) {
						ans[i] = weight * poll.mulWeight;
						break;
					}
					if (!visited.contains(neighbor)) {
						visited.add(neighbor);
						queue.offer(new NodeData(neighbor, poll.mulWeight * weight));
					}
				}
			}
		}
		
		return ans;
		
	}
	// 用于广度优先搜索储存数据的节点数据结构
	class NodeData{
		String var;       // 当前变量名
		double mulWeight; // 到达改节点累乘权重积
		
		NodeData(String var, double mulWeight) {
			// TODO Auto-generated constructor stub
			this.var = var;
			this.mulWeight = mulWeight;
		}
	}
}
















