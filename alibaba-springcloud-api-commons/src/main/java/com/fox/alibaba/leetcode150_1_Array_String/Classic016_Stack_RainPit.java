package com.fox.alibaba.leetcode150_1_Array_String;

import java.util.Deque;
import java.util.LinkedList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-06 11:38
* @version 1.0
*/
public class Classic016_Stack_RainPit {
	public static void main(String[] args) {
		Classic016_Stack_RainPit c97 = new Classic016_Stack_RainPit();
		int[] height = {1,1,1,2};
		System.out.println(c97.trap(height));

	}
	
	public int trap(int[] height) {
		int ans = 0;
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < height.length; i++) {
			while(!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
				int top = stack.pollLast();
				if (stack.isEmpty()) {
					break;
				}
                int left = stack.peekLast();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
			}
			stack.addLast(i);
		}
		
		
		
		return ans;
		
	}
}
