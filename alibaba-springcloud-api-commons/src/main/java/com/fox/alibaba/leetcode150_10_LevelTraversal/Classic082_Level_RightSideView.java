package com.fox.alibaba.leetcode150_10_LevelTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-16 17:14
* @version 1.0
*/
public class Classic082_Level_RightSideView {

	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, null, new TreeNode(5));
		TreeNode right = new TreeNode(3, null, new TreeNode(4));
		TreeNode root = new TreeNode(1, left, right);
		
		Classic082_Level_RightSideView c82 = new Classic082_Level_RightSideView();
		
		List<Integer> list = c82.rightSideView(root);
		
		if (list != null) {
			list.stream().forEach(v->System.out.println(v + " "));
		}
		
		System.out.println(list);
	}
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> ans = new ArrayList<>();
		if (root == null) return ans;
		
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			while(size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (size == 1) {
					ans.add(node.val);
				}
				size--;
			}
			
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
