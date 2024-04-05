package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 16:54
* @version 1.0
*/
public class ASimple_02_Postorder {
	public void postOrder1(TreeNode root){
        if(root==null){
            return ;
        }
        postOrder1(root.left);
        postOrder1(root.right);
        System.out.println(root.val);
    }
	public void postOrder2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null||stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top = stack.peek();
            if(top.right==null||top.right==prev){
                System.out.print(top.val+" ");
                prev=top;
                stack.pop();
            }
            else{
                cur=top.right;
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
