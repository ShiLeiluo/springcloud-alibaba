package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-11 14:26
* @version 1.0
*/
public class Classic078_Binary_MaxPathSum {

	public static void main(String[] args) {

		TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		TreeNode right = new TreeNode(5, null, new TreeNode(6));
		TreeNode root = new TreeNode(1, left, right);
		
		Classic078_Binary_MaxPathSum c78 = new Classic078_Binary_MaxPathSum();
		System.out.println(c78.maxPathSum(root));
		
		
	}
	int ans = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return ans;
	}
	
	private static final ExecutorService e = Executors.newFixedThreadPool(1);

	
	public int maxGain(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int leftTree = Math.max(maxGain(root.left), 0);
		int rightTree = Math.max(maxGain(root.right), 0);
		int currPath = root.val + leftTree + rightTree;
		ans = ans > currPath ? ans : currPath;
		
		return root.val + Math.max(leftTree, rightTree);
		
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
