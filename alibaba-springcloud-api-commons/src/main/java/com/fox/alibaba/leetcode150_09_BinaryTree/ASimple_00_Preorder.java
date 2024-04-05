package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 16:53
* @version 1.0
*/
public class ASimple_00_Preorder {
	
	
	public void preOrder1(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
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
