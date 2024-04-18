package com.fox.alibaba.leetcode150_10_LevelTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-17 09:09
* @version 1.0
*/
public class Classic083_Level_Average {


	public static void main(String[] args) {
		TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
		TreeNode root = new TreeNode(3, new TreeNode(9), right);
		
		Classic083_Level_Average c83 = new Classic083_Level_Average();
		
		System.out.println(c83.levelOrder(root));      
		
	}
	
	
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) return ans;
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.offer(root);
		
		boolean right = false;
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> levelList = new ArrayList<>();
			while (size > 0) {
				
				if (right) {
					TreeNode node = deque.pollLast();
					levelList.add(node.val);
					if (node.right != null) {
						deque.offerFirst(node.right);
					}
					if (node.left != null) {
						deque.offerFirst(node.left);
					}
				}else {
					TreeNode node = deque.pollFirst();
					levelList.add(node.val);
					if (node.left != null) {
						deque.offerLast(node.left);
					}
					if (node.right != null) {
						deque.offerLast(node.right);
					}
				}

				size--;
			}
			right = right?false:true;
			ans.add(levelList);
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
