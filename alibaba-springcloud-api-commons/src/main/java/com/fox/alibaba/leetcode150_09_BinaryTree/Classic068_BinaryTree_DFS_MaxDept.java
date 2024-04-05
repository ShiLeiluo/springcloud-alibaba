package com.fox.alibaba.leetcode150_09_BinaryTree;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-29 11:59
* @version 1.0
*/
public class Classic068_BinaryTree_DFS_MaxDept {
	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(3, new TreeNode(9), null);
		
		Classic068_BinaryTree_DFS_MaxDept c68 = new Classic068_BinaryTree_DFS_MaxDept();
		System.out.println(c68.maxDepth(rootNode));
	}
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}else {
			int leftHeight = maxDepth(root.left);
			int rightHeight = maxDepth(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	
	
	 public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode() {}
		     TreeNode(int val) { this.val = val; }
		     TreeNode(int val, TreeNode left, TreeNode right) {
		         this.val = val;
		         this.left = left;
		         this.right = right;
		     }
		 }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */