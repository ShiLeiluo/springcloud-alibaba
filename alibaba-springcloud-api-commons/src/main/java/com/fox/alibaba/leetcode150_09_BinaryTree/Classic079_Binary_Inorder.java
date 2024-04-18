package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.ArrayList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-12 10:52
* @version 1.0
*/
public class Classic079_Binary_Inorder {
	public static void main(String[] args) {

		TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		TreeNode right = new TreeNode(5, null, new TreeNode(6));
		TreeNode root = new TreeNode(1, left, right);
		
		new Classic079_Binary_Inorder(root);
		
		System.out.println(list.get(0));
		
	}

	private static int idx;
	private static ArrayList<Integer> list;
    public Classic079_Binary_Inorder(TreeNode root) {
    	idx = 0;
    	list = new ArrayList<>();
    	dfs_inorderTraversal(root);
    }
    private void dfs_inorderTraversal(TreeNode root) {
    	if (root == null) {
			return ;
		}
    	dfs_inorderTraversal(root.left);
    	list.add(root.val);
    	dfs_inorderTraversal(root.right);
    }
    
    public int next() {
    	idx += 1;
		return list.get(idx);

    }
    
    public boolean hasNext() {
		return idx < list.size();

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
