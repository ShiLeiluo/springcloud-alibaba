package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 16:53
* @version 1.0
*/
/**
 * 前序遍历: [1, 2, 4, 5, 3, 6, 7]
 * 中序遍历: [4, 2, 5, 1, 6, 3, 7]
 * 后序遍历: [4, 5, 2, 6, 7, 3, 1]
 * 层次遍历: [1, 2, 3, 4, 5, 6, 7]
 * @author F1337248
 *
 */
public class ASimple_02_Inorder {
	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
		TreeNode root = new TreeNode(1, left, right);
		
		ASimple_02_Inorder inorder = new ASimple_02_Inorder();
		inorder.inOrder_dfs(root);
	}
	public void inOrder_dfs(TreeNode root){
        if(root==null){
            return ;
        }
        inOrder_dfs(root.left);
        System.out.print(root.val+" ");
        inOrder_dfs(root.right);
    }
    public void inOrder_bfs(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.empty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
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
