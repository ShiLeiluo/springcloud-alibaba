 package com.fox.alibaba.algorithm;

import java.util.ArrayList;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-03 17:17
* @version 1.0
*/
public class Maze_Practice {
	static ArrayList<ArrayList<Pos>> lists = new ArrayList<ArrayList<Pos>>();
	public static void main(String[] args) {
		int[][] maze = {
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,0,0,0},
				{1,1,1,0,0},
				{1,1,1,1,0},
				};
		printMaze(maze);
		dfs(maze, 0, 0, new ArrayList<Pos>());
		for (ArrayList<Pos> list : lists) {
			System.out.println(list.size());
			list.forEach(t->System.out.println(t.dx+", "+t.dy));
			System.out.println("*************************");
		}

	}
	
	
	public static void dfs(int[][] maze, int dx, int dy, ArrayList<Pos> list) {
		int row = maze.length;
		int col = maze[0].length;
		if (dx < 0 || dx > row-1 || dy < 0 || dy > col-1 || maze[dx][dy] == 1) {
			return;
		}
		list.add(new Pos(dx, dy));
		if (dx == row-1 && dy == col -1) {
			lists.add(new ArrayList<>(list));
			
		}else {
			maze[dx][dy] = 1;
			dfs(maze, dx, dy+1, list);
			dfs(maze, dx+1, dy, list);
			dfs(maze, dx, dy-1, list);
			dfs(maze, dx-1, dy, list);
			maze[dx][dy] = 0;
		}
		list.remove(list.size()-1);
		
	}
	
	public static class Pos {
		int dx;
		int dy;
		public Pos(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
	}
	
	//输出Maze
	public static void printMaze(int[][] maze) {
		int row = maze.length;
		int col = maze[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(maze[i][j]+"   ");
			}
			System.out.println();
		}
		System.out.println("*************************");
	}
}
