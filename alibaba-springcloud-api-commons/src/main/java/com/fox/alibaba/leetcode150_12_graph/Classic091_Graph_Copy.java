package com.fox.alibaba.leetcode150_12_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-24 08:22
* @version 1.0
*/
public class Classic091_Graph_Copy {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		List<Node> neighbors1 = new ArrayList<>();
		neighbors1.add(n2);neighbors1.add(n4);
		List<Node> neighbors2 = new ArrayList<>();
		neighbors2.add(n1);neighbors2.add(n3);
		List<Node> neighbors3 = new ArrayList<>();
		neighbors3.add(n2);neighbors3.add(n4);
		List<Node> neighbors4 = new ArrayList<>();
		neighbors4.add(n1);neighbors4.add(n3);
		
		n1.neighbors = neighbors1;
		n2.neighbors = neighbors2;
		n3.neighbors = neighbors3;
		n4.neighbors = neighbors4;
		
		Classic091_Graph_Copy c91 = new Classic091_Graph_Copy();
		Node cloneNode = c91.cloneGraph(n1);
		System.out.println(cloneNode.val);
		for (Node neighbor : cloneNode.neighbors) {
			System.out.println(neighbor.val);
		}
	}
	
	private HashMap<Node, Node> visited = new HashMap<>();
	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		
		// 如果改节点被访问过了, 则直接从Hash表中取出对应的克隆节点返回
		if (visited.containsKey(node)) {
			return visited.get(node);
		}
		
		// 克隆节点, 为了深拷贝不克隆邻居列表
		Node cloneNode = new Node(node.val, new ArrayList<>());
		
		// 哈希表储存
		visited.put(node, cloneNode);
		
		// 遍历邻居节点, 更新克隆节点的邻居列表
		for (Node neighbor : node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}
		
		return cloneNode;
		
	}
	
	private static class Node{ 
		public int val;
		public List<Node> neighbors;
		public Node() {
			val = 0;
			neighbors = new ArrayList<>();
		}
		public Node(int val) {
			this.val = val;
		}
		public Node(int val, List<Node> neighbors) {
			this.val = val;
			this.neighbors = neighbors;
		}
	}
}
