package com.fox.alibaba.leetcode150_11_BinarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-19 08:27
* @version 1.0
*/
public class Classic088_Search_isBST {
	public static void main(String[] args) {
		TreeNode right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
		TreeNode root = new TreeNode(5, new TreeNode(1), right);
		Classic088_Search_isBST c88 = new Classic088_Search_isBST();
		
		System.out.println(c88.isValidBST(root));
	}
	
	public boolean isValidBST(TreeNode root) {

		boolean isBST = true;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		double pre = -Double.MAX_VALUE;
		while(!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}else {
				curr = stack.pop();
				if (pre >= curr.val) {
					isBST = false;
					break;
				}
				pre = curr.val;
				System.out.println(curr.val);
				curr = curr.right;
			}
		}
		
		return isBST;
	}
	
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
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
