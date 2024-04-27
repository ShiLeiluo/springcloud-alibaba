package com.fox.alibaba.leetcode150_12_graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-04-19 10:55
 * @version 1.0
 */
public class Classic089_Graph_IslandCount {
	public static void main(String[] args) {
		char grid[][] = { 
				{ '1', '1', '0', '0', '0' }, 
				{ '1', '1', '0', '0', '0' }, 
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		char grid2[][] = { 
				{ '1', '1', '0', '0', '0' }, 
				{ '1', '1', '0', '0', '0' }, 
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		Classic089_Graph_IslandCount c89 = new Classic089_Graph_IslandCount();
		System.out.println(c89.numIslands(grid));
		System.out.println(c89.numIslands_bfs(grid2));
	}

	public int numIslands(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					island_dfs(grid, i, j);
					count += 1;
				}
			}
		}
		return count;

	}

	private void island_dfs(char[][] grid, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		island_dfs(grid, i - 1, j);
		island_dfs(grid, i + 1, j);
		island_dfs(grid, i, j - 1);
		island_dfs(grid, i, j + 1);
	}

	public int numIslands_bfs(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int count = 0;
		Deque<Pos> deque = new ArrayDeque<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					
					deque.offer(new Pos(i, j));
					grid[i][j] = '0';
					while (!deque.isEmpty()) {
						Pos poll = deque.poll();
						int x = poll.x;
						int y = poll.y;
						if (x - 1 >= 0 && grid[x - 1][y] == '1') {
							deque.offer(new Pos(x - 1, y));
							grid[x - 1][y] = '0';
						}
						if (y - 1 >= 0 && grid[x][y - 1] == '1') {
							deque.offer(new Pos(x, y - 1));
							grid[x][y - 1] = '0';
						}
						if (x + 1 < rows && grid[x + 1][y] == '1') {
							deque.offer(new Pos(x + 1, y));
							grid[x + 1][y] = '0';
						}
						if (y + 1 < cols && grid[x][y + 1] == '1') {
							deque.offer(new Pos(x, y + 1));
							grid[x][y + 1] = '0';
						}
					}
					count += 1;
				}
			}
		}

		return count;

	}

	public static class Pos {
		private int x;
		private int y;

		public Pos() {

		}

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
