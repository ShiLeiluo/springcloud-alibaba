package com.fox.alibaba.leetcode150_09_BinaryTree;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-01 09:32
* @version 1.0
*/
public class Classic070_Binary_Invert {
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.left);
		
		root.left = right;
		root.right = left;
		return root;
	}
	
	private static class TreeNode{
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
