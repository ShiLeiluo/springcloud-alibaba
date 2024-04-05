package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 16:53
* @version 1.0
*/
public class ASimple_01_Inorder {
	public void inOrder1(TreeNode root){
        if(root==null){
            return ;
        }
        inOrder1(root.left);
        System.out.print(root.val+" ");
        inOrder1(root.right);
    }
    public void inOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            else{
                cur=stack.pop();
                System.out.print(cur.val+" ");
                cur=cur.right;
            }
        }
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
