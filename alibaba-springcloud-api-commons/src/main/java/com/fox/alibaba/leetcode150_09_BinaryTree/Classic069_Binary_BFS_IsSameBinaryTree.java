package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-29 14:38
* @version 1.0
*/
public class Classic069_Binary_BFS_IsSameBinaryTree {
	public static void main(String[] args) {
		TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		TreeNode q = new TreeNode(1, new TreeNode(3), new TreeNode(3));
		
		Classic069_Binary_BFS_IsSameBinaryTree c69 = new Classic069_Binary_BFS_IsSameBinaryTree();
		System.out.println(c69.isSameTree(p, q));
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if ((p != null && q == null) || p == null && q != null) return false;
		
		boolean isSame = true;
		if (p.val != q.val) {
			isSame = false;
		}
		
		Queue<TreeNode> pQueue = new LinkedList<>();
		Queue<TreeNode> qQueue = new LinkedList<>();

		pQueue.offer(p);qQueue.offer(q);
		
		
		while (!pQueue.isEmpty() || !qQueue.isEmpty()) {
			if (!isSame) {
				break;
			}
			if (pQueue.isEmpty() || qQueue.isEmpty()) {
				isSame = false;
				break;
			}
			int pSize = pQueue.size();
			int qSize = qQueue.size();
			while (pSize != 0 || qSize != 0) {
				if (pSize == 0 || qSize == 0) {
					isSame = false;
					break;
				}
				TreeNode pNode = pQueue.poll();
				TreeNode qNode = qQueue.poll();
				if ((pNode.left != null && qNode.left == null) || (pNode.left == null && qNode.left != null)) {
					isSame = false;
					break;
				}
				if ((pNode.right != null && qNode.right == null) || (pNode.right == null && qNode.right != null)) {
					isSame = false;
					break;
				}
				
				if (pNode.left != null && qNode.left != null) {
					if (pNode.left.val != qNode.left.val) {
						isSame = false;
						break;
					}
					pQueue.offer(pNode.left);
					qQueue.offer(qNode.left);
				}
				if (pNode.right != null && qNode.right != null) {
					if (pNode.right.val != qNode.right.val) {
						isSame = false;
						break;
					}
					pQueue.offer(pNode.right);
					qQueue.offer(qNode.right);
				}
				pSize -= 1;
				qSize -= 1;
			}
			
		}
		
		
		
		
		return isSame;
		
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
