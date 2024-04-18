package com.fox.alibaba.leetcode150_09_BinaryTree;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-16 10:07
* @version 1.0
*/
public class Classic081_Binary_Ancestor {
	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(2, new TreeNode(7), new TreeNode(4));
		TreeNode root2 = new TreeNode(5, new TreeNode(6), root1);
		TreeNode root3 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
		TreeNode root = new TreeNode(3, root2, root3);
		
		Classic081_Binary_Ancestor c81 = new Classic081_Binary_Ancestor();

		System.out.println(c81.lowestCommonAncestor(root, root1, root2).val);
	}
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
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
