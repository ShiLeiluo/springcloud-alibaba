package com.fox.alibaba.leetcode150_07_Satck;

import java.util.ArrayDeque;
import java.util.Deque;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-20 10:33
* @version 1.0
*/
public class Classic056_Stack_Calculator {
	public static void main(String[] args) {
		Classic056_Stack_Calculator c55 = new Classic056_Stack_Calculator();
		String s = "(5-(1+(5)))";
		System.out.println(c55.calculate(s));
	}
	
	public int calculate(String s) {

		Deque<Character> stack = new ArrayDeque<>();
		
		int ans = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)==' ') continue;
			
			if (s.charAt(i)==')') {
				int bracketTotal = 0;
				while (stack.peek()!='(') {
					int num = getANum(stack);

					if (stack.peek()=='(') {
						bracketTotal += num;
						continue;
					}
					if (stack.peek()=='+') {
						bracketTotal += num;
						stack.pop();
						continue;
					}
					if (stack.peek()=='-') {
						bracketTotal -= num;
						stack.pop();
						continue;
					}

					
				}
				if (stack.peek()=='(') {
					stack.pop();
					if (stack.isEmpty()) {
						if (bracketTotal<0) {
							stack.push('-');
						}
						pushNum(stack, bracketTotal);
						continue;
					}
					if (bracketTotal<0) {
						if (stack.peek() == '-') {
							stack.pop();
							stack.push('+');
						}else {
							stack.pop();
							stack.push('-');
						}
					}
					pushNum(stack, bracketTotal);
				}
				continue;
			}
			stack.push(s.charAt(i));
		}
		
		while (!stack.isEmpty()) {
			int num = getANum(stack);
			if (stack.isEmpty()) {
				ans += num;
				break;
			}
			if (stack.peek()=='+') {
				ans += num;
			}
			if (stack.peek()=='-') {
				ans -= num;
				
			}
			stack.pop();
		}
		return ans;
	}
	//	String str = ""; 
	//	boolean isNum = str.matches("[0-9]+"); 
	//+表示1个或多个（如"3"或"225"），*表示0个或多个（[0-9]*）（如""或"1"或"22"），?表示0个或1个([0-9]?)(如""或"7") 

	private int getANum(Deque<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
			sb.append(stack.pop());
			
		}
		return Integer.parseInt(sb.reverse().toString());
	}
	private void pushNum(Deque<Character> stack, int num) {
		String s = String.valueOf(num);
		int len = s.length();
		int i = num<0?1:0;
		while (i<len) {
			stack.push(s.charAt(i));
			i++;
		}

	}
}
