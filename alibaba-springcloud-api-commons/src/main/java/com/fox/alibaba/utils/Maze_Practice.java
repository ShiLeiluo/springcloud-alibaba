package com.fox.alibaba.utils;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-03 17:17
* @version 1.0
*/
public class Maze_Practice {
	public static void main(String[] args) {
		int[][] maze = {
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,0,0,0},
				{1,1,1,0,0},
				{1,1,1,1,0},
				};
		printMaze(maze);
	}
	
	//输出Maze
	
	private static void printMaze(int[][] maze) {
		int row = maze.length;
		int col = maze[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(maze[i][j]+"   ");
			}
			System.out.println();
		}
	}
}
