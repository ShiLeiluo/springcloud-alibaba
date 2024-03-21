package com.fox.alibaba.leetcode150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-20 10:33
* @version 1.0
*/
public class Classic055_Stack_Calculator {
	public static void main(String[] args) {
		Classic055_Stack_Calculator c55 = new Classic055_Stack_Calculator();
		String s = "- (3 + (4 + 5))";
		System.out.println(c55.calculate(s));
	}
	
	public int calculate(String s) {
		int len = s.length();

		Deque<Character> stack = new ArrayDeque<>();
		
		int ans = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (i==s.length()-1 || s.charAt(i)==')') {
				
			}
		}
		
		
		return ans;
	}
	
}
