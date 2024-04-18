package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-11 14:02
* @version 1.0
*/
public class Classic077_Binary_PathLine {
	public static void main(String[] args) {

		TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		TreeNode right = new TreeNode(5, null, new TreeNode(6));
		TreeNode root = new TreeNode(1, left, right);
		
		Classic077_Binary_PathLine c77 = new Classic077_Binary_PathLine();
		
		c77.sumMumbers(root);
		
	}
	public void sumMumbers(TreeNode root) {
		
		
		System.out.println(sumMumbers_DFS(root, 0));
		System.out.println(sumMumbers_BFS(root));
	}
	
    public int sumMumbers_DFS(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return sumMumbers_DFS(root.left, sum) + sumMumbers_DFS(root.right, sum);
        }
    }

	
	public int sumMumbers_BFS(TreeNode root) {

		Queue<TreeNode> queueNodes = new LinkedList<>();
		queueNodes.offer(root);
		Queue<Integer> pathNums = new LinkedList<>();
		pathNums.offer(root.val);
		int ans = 0;
		while (!queueNodes.isEmpty()) {
			TreeNode currNode = queueNodes.poll();
			int temp = pathNums.poll();
			
			if (currNode.left == null && currNode.right == null) {
				ans += temp;
			}
			
			if (currNode.left != null) {
				queueNodes.offer(currNode.left);
				pathNums.offer(temp*10 + currNode.left.val);
			}
			if (currNode.right != null) {
				queueNodes.offer(currNode.right);
				pathNums.offer(temp*10 + currNode.right.val);
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
