package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-09 14:27
* @version 1.0
*/
public class Classic075_Binary_Flatten {
	public static void main(String[] args) {
		Classic075_Binary_Flatten c75 = new Classic075_Binary_Flatten();
		TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		TreeNode right = new TreeNode(5, null, new TreeNode(6));
		TreeNode root = new TreeNode(1, left, right);
		c75.flatten(root);
		
		while(root != null) {
			System.out.println(root.val);
			root = root.right;
		}
		
	}
	
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
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
