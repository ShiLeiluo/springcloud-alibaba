package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 15:52
* @version 1.0
*/
public class Classic072_Binary_PreorderNInorder2BuildTree {
	public static void main(String[] args) {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		
		Classic072_Binary_PreorderNInorder2BuildTree c72 = new Classic072_Binary_PreorderNInorder2BuildTree();
		
		TreeNode root = c72.buildTree(preorder, inorder);
		
		LinkedList<Integer> list = new LinkedList<>();
		
		c72.getPreorder(root, list);
		
		System.out.println(list.toString());
		
		c72.preOrder2(root);
		
	}
	
	public void getPreorder(TreeNode root, LinkedList<Integer> tree) {
		if (root == null) {
			tree.add(null);
			return ;
		}
		
		tree.add(root.val);
		getPreorder(root.left, tree);
		getPreorder(root.right, tree);
	}
	public void preOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty()||cur!=null){
            if(cur!=null){
                //打印根节点
                System.out.print(cur.val+" ");
                //根节点入栈
                stack.push(cur);
                //访问左子树
                cur=cur.left;
            }
            else{
                cur=stack.pop().right;
            }
        }
    }
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 递归, 搞一个出口
		int preLen = preorder.length;
		if(preLen == 0) {
			return null;
		}
		
		// 1. 根据前序, 找到根的值, 并创建根节点
		int rootVal = preorder[0];
		TreeNode root = new TreeNode(preorder[0]);
		
		// 2. 在中序中找到根节点下标
		int leftSize = getIndex(inorder, rootVal);
		
		// 3. 切出左子树的前序和中序
		int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1+leftSize);
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
		root.left = buildTree(leftPreorder, leftInorder);
		
		// 4. 切出右子树的前序和中序
		int[] rightPreorder = Arrays.copyOfRange(preorder, 1+leftSize, preLen);
		int[] rightInorder = Arrays.copyOfRange(inorder, 1+leftSize, preLen);
		root.right = buildTree(rightPreorder, rightInorder);
		
		return root;
		
	}
	
	private static int getIndex(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val) {
				return i;
			}
		}
		return -1;
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
