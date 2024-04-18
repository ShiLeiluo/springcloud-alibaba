package com.fox.alibaba.leetcode150_11_BinarySearch;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-17 14:28
* @version 1.0
*/
public class Classic086_Search_MinDiff {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3)); 
		TreeNode root = new TreeNode(4, left, new TreeNode(6));
		
		Classic086_Search_MinDiff c86 = new Classic086_Search_MinDiff();
		System.out.println(c86.getMinmumDifference(root));
	}
	
	public int getMinmumDifference(TreeNode root) {
		
		
		return 0;
		
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
