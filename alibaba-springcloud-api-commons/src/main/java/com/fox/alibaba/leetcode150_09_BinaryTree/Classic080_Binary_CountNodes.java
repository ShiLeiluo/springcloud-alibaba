package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-16 09:39
* @version 1.0
*/
public class Classic080_Binary_CountNodes {
	public static void main(String[] args) {

		TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		TreeNode right = new TreeNode(5, null, new TreeNode(6));
		TreeNode root = new TreeNode(1, left, right);
		
		Classic080_Binary_CountNodes c80 = new Classic080_Binary_CountNodes();
		
		System.out.println(c80.countNodes(root));
		
		
	}
	// 总节点数: Math.pow(2, Depth) - 1
	// 第i层节点数: Math.pow(2, i-1)
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		int count = 0;
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size > 0) {
				TreeNode node = deque.poll();
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
				count++;
				size--;
			}
			
		}
		return count;
		
	}
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
			
		}
		public TreeNode(int val) {
			this.val = val;

		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
