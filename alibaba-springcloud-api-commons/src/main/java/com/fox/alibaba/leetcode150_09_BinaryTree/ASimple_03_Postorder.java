package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-02 16:54
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
public class ASimple_03_Postorder {
	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
		TreeNode root = new TreeNode(1, left, right);
		
		ASimple_03_Postorder postorder = new ASimple_03_Postorder();
		postorder.postOrder_dfs(root);
	}
	public void postOrder_dfs(TreeNode root){
        if(root==null){
            return ;
        }
        postOrder_dfs(root.left);
        postOrder_dfs(root.right);
        System.out.print(root.val + " ");
    }
	public void postOrder_bfs(TreeNode root){
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
            }else{
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
