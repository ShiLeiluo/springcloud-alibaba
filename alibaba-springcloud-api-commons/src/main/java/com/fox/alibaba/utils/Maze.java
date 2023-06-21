package com.fox.alibaba.utils;

import java.util.ArrayList;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-06-20 19:00
 * @version 1.0
 */
public class Maze {
	private static ArrayList<ArrayList<Pos>> lists = new ArrayList<ArrayList<Pos>>();
	public static void main(String[] args) {
		int[][] maze = {
				{0,0,0,0,0},
				{0,1,1,1,0},
				{0,0,0,0,0},
				{1,1,1,0,0},
				{1,1,1,1,0},
				};
		
		ArrayList<Pos> arrayList = new ArrayList<Pos>();
		arrayList.add(new Pos(0, 0));
		dfs(maze, 0, 0, arrayList);
		
		for (ArrayList<Pos> list : lists) {
			System.out.println("steps: "+list.size());
			list.forEach(t->System.out.println("("+t.x+", "+t.y+")"));
			System.out.println("******************************");
		}
		
	}
	
	public static void dfs(int[][] maze, int i, int j, ArrayList<Pos> list) {
		int row = maze.length;
		int col = maze[0].length;
		if (i<0 || i>row-1 || j<0 || j>col-1 || maze[i][j] == 1) {
			return;
		}
		
		if (i==row-1 && j==col-1) {
			list.add(new Pos(i, j));
			lists.add(new ArrayList<>(list));
			list.remove(list.size()-1);
		}else {
			list.add(new Pos(i, j));
			maze[i][j] = 1;
			dfs(maze, i, j+1, list);
			dfs(maze, i+1, j, list);
			dfs(maze, i, j-1, list);
			dfs(maze, i-1, j, list);
			maze[i][j] = 0;
			list.remove(list.size()-1);
		}
		

	}
	
	public static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
