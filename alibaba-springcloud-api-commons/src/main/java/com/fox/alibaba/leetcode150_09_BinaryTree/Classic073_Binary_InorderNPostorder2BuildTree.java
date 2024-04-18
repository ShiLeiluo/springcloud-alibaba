package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-08 10:36
* @version 1.0
*/
public class Classic073_Binary_InorderNPostorder2BuildTree {
	public static void main(String[] args) {
//		TreeNode treeRoot = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		Classic073_Binary_InorderNPostorder2BuildTree c73 = new Classic073_Binary_InorderNPostorder2BuildTree();
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = c73.buildTree(inorder, postorder);
		c73.printTreeNode(root);
	}
	
	
	private void printTreeNode(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		list.offer(root);
		while (!list.isEmpty()) {
			int size = list.size();
			while (size > 0) {
				TreeNode treeNode = list.poll();
				sb.append(treeNode.val+", ");
				if (treeNode.left != null) {
					list.offer(treeNode.left);
				}
				if (treeNode.right != null) {
					list.offer(treeNode.right);
				}
				
				size -= 1;
			}
			
		}
		System.out.println(sb.substring(0, sb.length()-2)+"]");
	}
	
	HashMap<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// 1. 构建中序遍历数组值与下标的集合Map
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		
		return buildTreeWithMap(inorder, postorder);
	}
	
	public TreeNode buildTreeWithMap(int[] inorder, int[] postorder) {
		// 1. 递归出口
		int postorderLen = postorder.length;
		if (postorderLen == 0) {
			return null;
		}
		
		// 2. 根据后序, 找到根的值, 创建根节点
		int rootVal = postorder[postorderLen - 1];
		TreeNode root = new TreeNode(rootVal);
		
		// 3. 在中序遍历中找到根节点下标
		int leftSize = map.get(rootVal);
		
		// 4. 切出左子树的中序和后序
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
		int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftSize);
		root.left = buildTreeWithMap(leftInorder, leftPostorder);
		// 5. 切出右子树的中序和后序
		int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, postorderLen);
		int[] rightPostorder = Arrays.copyOfRange(postorder, leftSize , postorderLen - 1);
		root.right = buildTree(rightInorder, rightPostorder);
		return root;
		
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
