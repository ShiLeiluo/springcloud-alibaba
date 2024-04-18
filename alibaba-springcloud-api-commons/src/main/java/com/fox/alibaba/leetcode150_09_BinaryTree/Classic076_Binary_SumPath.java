package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-10 15:56
* @version 1.0
*/
public class Classic076_Binary_SumPath {
	public static void main(String[] args) {

		TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		TreeNode right = new TreeNode(5, null, new TreeNode(6));
		TreeNode root = new TreeNode(1, left, right);
		
		Classic076_Binary_SumPath c76 = new Classic076_Binary_SumPath();
		
		System.out.println(c76.hasPathSum_BFS(root, 7));
		System.out.println(c76.hasPathSum_DFS(root, 7));
	}
	// 深度优先搜索算法（Depth-First-Search） 深度优先搜索算法（Depth-First-Search）
	//层次遍历, 创建两个队列储存节点值, 路径值加总
	public boolean hasPathSum_BFS(TreeNode root, int targetSum) {
		
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return targetSum == root.val;
		}
		return hasPathSum_BFS(root.left, targetSum - root.val) || hasPathSum_BFS(root.right, targetSum - root.val);

	}
	public boolean hasPathSum_DFS(TreeNode root, int targetSum) {
		if (root == null) return false;
		boolean isExists = false;

		Queue<TreeNode> stackNode = new LinkedList<>();
		Queue<Integer> sumNode = new LinkedList<>();
		
		stackNode.offer(root);
		
		sumNode.offer(root.val);
		while(!stackNode.isEmpty()) {
			TreeNode now = stackNode.poll();
			int temp = sumNode.poll();
			if (now.left == null && now.right == null) {
				if (temp == targetSum) {
					isExists = true;
					break;
				}
			}
//			System.out.println(now.val);
			if (now.left != null) {
				stackNode.offer(now.left);
				sumNode.offer(temp + now.val);
			}
			if (now.right != null) {
				stackNode.offer(now.right);
				sumNode.offer(temp + now.val);
			}
		}
		
		return isExists;
		
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
