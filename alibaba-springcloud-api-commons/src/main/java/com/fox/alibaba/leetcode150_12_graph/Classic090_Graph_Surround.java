package com.fox.alibaba.leetcode150_12_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-04-23 11:39
* @version 1.0
*/
public class Classic090_Graph_Surround {
	public static void main(String[] args) {
		char[][] board = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}};
		Classic090_Graph_Surround c99 = new Classic090_Graph_Surround();
		c99.slove(board);
		Arrays.stream(board).forEach(row->System.out.println(Arrays.toString(row)));
		char[][] board2 = {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}};
		
		c99.slove_dfs(board2);
		Arrays.stream(board2).forEach(row->System.out.println(Arrays.toString(row)));
	}
	int rows;
	int cols;
	public void slove_dfs(char[][] board){
		rows = board.length;
		cols = board[0].length;
		
		for (int i = 0; i < rows; i++) {
			recursion(board, i, 0);
			recursion(board, i, cols - 1);
		}
		for (int j = 1; j < cols - 1; j++) {
			recursion(board, 0, j);
			recursion(board, rows - 1, j);
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = 'O';
				}else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}
	
	private void recursion(char[][] board, int x, int y) {
		
		if (x < 0 || y < 0 || x >= rows || y >= cols || board[x][y] != 'O') {
			return;
		}
		board[x][y] = 'A';
		recursion(board, x-1, y);
		recursion(board, x+1, y);
		recursion(board, x, y-1);
		recursion(board, x, y+1);
	}
	
	public void slove(char[][] board){
		int rows = board.length;
		int cols = board[0].length;
		
		Deque<Pos> queue = new LinkedList<>();
		boolean change = true;
		List<Deque<Pos>> islands = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					Deque<Pos> island = new LinkedList<>();
					queue.offer(new Pos(i, j));
					board[i][j] = 'X';
					while (!queue.isEmpty()) {
						Pos poll = queue.poll();
						island.offer(poll);
						int x = poll.x;
						int y = poll.y;
						if(x == 0 || y == 0 || x == rows - 1 || y == cols - 1) {
							change = false;
						}
						board[x][y] = 'X';
						if (x - 1 >= 0 && board[x-1][y] == 'O') {

							queue.offer(new Pos(x-1, y));
						}
						if (y - 1 >= 0 && board[x][y-1] == 'O') {

							queue.offer(new Pos(x, y-1));
						}
						if (x + 1 < rows && board[x+1][y] == 'O') {

							queue.offer(new Pos(x+1, y));
						}
						if (y + 1 < cols && board[x][y+1] == 'O') {

							queue.offer(new Pos(x, y+1));
						}

					}
					if (!change) {
						islands.add(island);
						change = true;
					}
				}
			}
		}
		
		for (int i = 0; i < islands.size(); i++) {
			Deque<Pos> island = islands.get(i);
			while (!island.isEmpty()) {
				Pos poll = island.poll();
				board[poll.x][poll.y] = 'O';
			}
		}
		
	}
	public static class Pos{
		int x;
		int y;
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
