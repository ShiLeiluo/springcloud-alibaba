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
public class ASimple_01_Preorder {
	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
		TreeNode root = new TreeNode(1, left, right);
		
		ASimple_01_Preorder preorder = new ASimple_01_Preorder();
		preorder.preOrder_dfs(root);
	}
	
	public void preOrder_dfs(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.print(root.val + " ");
        preOrder_dfs(root.left);
        preOrder_dfs(root.right);
    }
    public void preOrder_bfs(TreeNode root){
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
            }else{
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
