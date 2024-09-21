package com.fox.alibaba.leetcode150_16_DivideNConquer;

/**
* @author F1337248 ShiLeiluo
* @date 2024-06-12 15:39
* @version 1.0
*/
public class Classic107_DivideNConquer_Sorted2BST {
	public static void main(String[] args) {
		Classic107_DivideNConquer_Sorted2BST c107 = new Classic107_DivideNConquer_Sorted2BST();
		int[] nums = {-10,-3,0,5,9};
		c107.printTree(c107.sortedArrayToBST(nums));
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	
	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		return root;
	}
	
	public void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.val + " ");
		
		printTree(root.left);
		printTree(root.right);
	}
	
	public class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode() {
			// TODO Auto-generated constructor stub
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
