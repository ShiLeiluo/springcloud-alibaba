package com.fox.alibaba.leetcode150_10_LevelTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-17 09:09
* @version 1.0
*/
public class Classic085_Level_LevelorderZigag {


	public static void main(String[] args) {
		TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
		TreeNode root = new TreeNode(3, new TreeNode(9), right);
		
		Classic085_Level_LevelorderZigag c83 = new Classic085_Level_LevelorderZigag();
		
		System.out.println(c83.averageOfLevels(root));
		
	}
	public List<Double> averageOfLevels(TreeNode root){
		List<Double> ans = new ArrayList<>();
		
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			int count = size;
			Double level = 0d;
			while (size > 0) {
				TreeNode node = queue.poll();
				level += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
			ans.add(level / count);
		}
		
		return ans;
		
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
