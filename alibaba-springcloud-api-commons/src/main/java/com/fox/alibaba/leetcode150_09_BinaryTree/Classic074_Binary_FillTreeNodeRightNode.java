package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-09 11:48
* @version 1.0
*/
public class Classic074_Binary_FillTreeNodeRightNode {
	public static void main(String[] args) {
		
	}
	
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		
		
		LinkedList<Node> deque = new LinkedList<>();
		deque.offer(root);
		
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size > 0) {
				Node node = deque.poll();
				if (size > 1) {
					node.next = deque.peek();
				}
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
				size--;
			}
			
		}
		
		return root;
		
	}
	
	
	private static class Node{
		int val;
		Node left;
		Node right;
		Node next;
		
		
		public Node(int val) {
			this.val = val;
		}
		public Node(int val, Node left, Node right, Node next) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.next = next;
		}
	}
}
