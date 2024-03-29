package com.fox.alibaba.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-26 16:48
* @version 1.0
*/
public class Maze_BFS {

	public static void main(String[] args) {
		int[][] maze = {
				{0, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 0, 0, 0, 0},
				{0, 1, 0, 1, 1, 0},
				{0, 1, 0, 1, 1, 0},
				{0, 0, 0, 1, 1, 0}
				};
		int row = maze.length;
		int col = maze[0].length;
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0, null));
		maze[0][0] = 1;
		
		Pos p = null;
		
		//将所有0 加入queue
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			int px = p.x;
			int py= p.y;
			
			if(px == row-1 && py == col-1) {
				System.out.println();
				break;
			}else {
				if (px-1 >= 0 && maze[px-1][py] == 0) {
					maze[px-1][py] = 1;
					queue.offer(new Pos(px-1, py, p));
				}
				if (px+1 < row && maze[px+1][py] == 0) {
					maze[px+1][py] = 1;
					queue.offer(new Pos(px+1, py, p));
				}
				if (py-1 >= 0 && maze[px][py-1] == 0) {
					maze[px][py-1] = 1;
					queue.offer(new Pos(px, py-1, p));
				}
				if (py+1 < col && maze[px][py+1] == 0) {
					maze[px][py+1] = 1;
					queue.offer(new Pos(px, py+1, p));
				}
			}
			
		}
		//
		Stack<Pos> stack = new Stack<>();
		
		while (p != null) {
			stack.push(p);
			p = p.father;
			
		}
		
		while (!stack.isEmpty()) {
			Pos t = stack.pop();
			
			System.out.println("("+t.x+","+t.y+")");
			
		}
	}
	
	
	
	public static class Pos {
		int x;
		int y;
		Pos father;
		
		public Pos(int x, int y, Pos father) {
			this.x = x;
			this.y = y;
			this.father = father;
		}
	}

}
