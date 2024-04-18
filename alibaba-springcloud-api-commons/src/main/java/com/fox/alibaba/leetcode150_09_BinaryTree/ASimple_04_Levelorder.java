package com.fox.alibaba.leetcode150_09_BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-16 11:55
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
public class ASimple_04_Levelorder {
	public static void main(String[] args) {
		TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		TreeNode right = new TreeNode(3, new TreeNode(6), new TreeNode(7));
		TreeNode root = new TreeNode(1, left, right);
		
		ASimple_04_Levelorder levelorder = new ASimple_04_Levelorder();
		levelorder.levelorder_bfs(root);
	}
	
	public void levelorder_bfs(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			while (size > 0) {
				TreeNode node = deque.poll();
				System.out.println(node.val);
				if (node.left != null) {
					deque.offer(node.left);
				}
				if (node.right != null) {
					deque.offer(node.right);
				}
				size--;
			}
			
		}
	}
    public List<List<Integer>> levelOrder_dfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, 0, result);
        return result;
    }
    private void levelOrderHelper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        // 如果当前层数已经超过结果列表的大小，说明是新的一层
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        // 将当前节点的值添加到对应层级的列表中
        result.get(level).add(node.val);
        // 对左子节点进行递归，层数增加
        levelOrderHelper(node.left, level + 1, result);
        // 对右子节点进行递归，层数增加
        levelOrderHelper(node.right, level + 1, result);
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
