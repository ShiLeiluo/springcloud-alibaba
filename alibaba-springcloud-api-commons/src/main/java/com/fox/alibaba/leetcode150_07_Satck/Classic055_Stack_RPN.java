package com.fox.alibaba.leetcode150_07_Satck;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-20 09:19
* @version 1.0
*/
public class Classic055_Stack_RPN {
	public static void main(String[] args) {
		Classic055_Stack_RPN c54 = new Classic055_Stack_RPN();
		String[] tokens = {"2","1","+","3","*"};
		System.out.println(c54.evalRPN(tokens));
	}
	
	public int evalRPN(String[] tokens) {
		Deque<Integer> stack = new ArrayDeque<>();
		Set<String> operator = new HashSet<>(4);
		operator.add("+");operator.add("-");operator.add("*");operator.add("/");
		for (int i = 0; i < tokens.length; i++) {
			if (operator.contains(tokens[i])) {
				int s2 = stack.pop();
				int s1 = stack.pop();
				stack.push(operation(tokens[i], s1, s2));
			}else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		
		return stack.pop();
		
	}
	private int operation(String operator, int s1, int s2) {
		int res = 0;
		switch (operator) {
		case "+":
			res = s1 + s2;
			break;
		case "-":
			res = s1 - s2;
			break;
		case "*":
			res = s1 * s2;
			break;
		case "/":
			res = s1 / s2;
			break;
		default:
			break;
		}
		return res;
	}
}
