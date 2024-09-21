package com.fox.alibaba.leetcode150_13_graph_bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-29 09:10
* @version 1.0
*/
public class Classic094_Graph_BFS_SnakeLadderChess {
	
	public static void main(String[] args) {
		int[][] board = {
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,35,-1,-1,13,-1},
				{-1,-1,-1,-1,-1,-1},
				{-1,15,-1,-1,-1,-1}
						};
		Arrays.stream(board).forEach(row->System.out.println(Arrays.toString(row)));
		Classic094_Graph_BFS_SnakeLadderChess c94 = new Classic094_Graph_BFS_SnakeLadderChess();
		System.out.println(c94.snakesAndLadders(board));
		
	}
    // 将二维的矩阵「扁平化」为一维的矩阵
    public int snakesAndLadders(int[][] board) {
    	int n = board.length;
        if (board[0][0] != -1) return -1;
        int[] nums = new int[n * n + 1];
        boolean isRight = true;
        for (int i = n - 1, idx = 1; i >= 0; i--) {
            for (int j = (isRight ? 0 : n - 1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            isRight = !isRight;
        }
        int ans = bfs(n, nums);
        return ans;
    }
    private static int bfs(int n, int[] nums) {
        Queue<Integer> d = new LinkedList<Integer>();
        Map<Integer, Integer> m = new HashMap<>();
        d.offer(1);
        m.put(1, 0);
        while (!d.isEmpty()) {
            int poll = d.poll();
            int step = m.get(poll);
            if (poll == n * n) {
            	return step;
            }
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if (np <= 0 || np > n * n) {
                	continue;
                }
                if (nums[np] != -1) {
                	np = nums[np];
                }
                if (m.containsKey(np)) {
                	continue;
                }
                m.put(np, step + 1);
                d.offer(np);
            }
        }
        return -1;
    }
}
