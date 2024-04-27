package com.fox.alibaba.leetcode150_11_BinarySearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-18 16:04
* @version 1.0
*/
public class Classic087_Search_KNumber {

	public static void main(String[] args) {
		TreeNode left1 = new TreeNode(2, new TreeNode(1), null);
		TreeNode left2 = new TreeNode(3, left1, new TreeNode(4));
		TreeNode root = new TreeNode(5, left2, new TreeNode(6));
		
		Classic087_Search_KNumber c87 = new Classic087_Search_KNumber();
		int k = 3;
		System.out.println(c87.kthSmallest(root, k));
	}

	public int kthSmallest(TreeNode root, int k) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		int i = 0;
		TreeNode curr = root;
		int ans = -1;
		while(!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}else {
				curr = stack.pop();
				i += 1;
				if (i == k) {
					ans = curr.val;
					break;
				}
				curr = curr.right;
			}
		}
		return ans;
		
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
