package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-01 10:36
* @version 1.0
*/
public class Classic071_Binary_Symmetrix {
	public static void main(String[] args) {
		Classic071_Binary_Symmetrix c71 = new Classic071_Binary_Symmetrix();
		
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(2);
		TreeNode root4 = new TreeNode(3);
		TreeNode root5 = new TreeNode(4);
		TreeNode root6 = new TreeNode(4);
		TreeNode root7 = new TreeNode(3);
		root1.left = root2; root1.right = root3;
		root2.left = root4; root2.right = root5;
		root3.left = root6; root3.right = root7;
		System.out.println(c71.isSymmetrix(root1));
	}
	 public boolean check(TreeNode p, TreeNode q) {
	        if (p == null && q == null) {
	            return true;
	        }
	        if (p == null || q == null) {
	            return false;
	        }
	        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
	    }

	
	public boolean isSymmetrix(TreeNode root) {
		System.out.println(check(root, root));
		Deque<TreeNode> linkedList = new LinkedList<>();
		linkedList.offer(root);
		
		boolean isSymmetrix = true;
		while(!linkedList.isEmpty()) {
			int size = linkedList.size();

			Deque<Integer> layer = new LinkedList<>();

			while(size > 0) {
				TreeNode poll = linkedList.poll();
				System.out.println(poll.val);
				
				if (poll.left != null) {
					linkedList.offer(poll.left);
					layer.offer(poll.left.val);
				}else {
					layer.offer(null);
				}
				if (poll.right != null) {
					linkedList.offer(poll.right);
					layer.offer(poll.right.val);
				}else {
					layer.offer(null);
				}
				
				size--;
			}
			while (layer.size() > 1) {
				if (layer.pollFirst() != layer.pollLast()) {
					isSymmetrix = false;
					break;
				}
				
			}
			layer.poll();
			if (!isSymmetrix) {
				break;
			}
		}
		
		return isSymmetrix;
		
	}
	
	private static class TreeNode{
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
