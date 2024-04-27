package com.fox.alibaba.leetcode150_11_BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-17 14:28
* @version 1.0
*/
public class Classic086_Search_MinDiff {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(104, null, new TreeNode(227)); 
		TreeNode right = new TreeNode(701, null, new TreeNode(911)); 
		TreeNode root = new TreeNode(236, left, right);
		
		Classic086_Search_MinDiff c86 = new Classic086_Search_MinDiff();
		System.out.println(c86.getMinmumDifference(root));
	}
	
	public int getMinmumDifference(TreeNode root) {
		
		
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		ArrayList<Integer> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		Collections.sort(list);
		int minDiff = Integer.MAX_VALUE;
		
		for (int i = 0; i < list.size() - 1; i++) {
			minDiff = Math.min(minDiff, list.get(i+1) - list.get(i));
		}
		
		return minDiff;
		
	}
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {}
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
