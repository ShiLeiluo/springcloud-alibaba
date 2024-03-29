package com.fox.alibaba.leetcode150_7_Satck;

import java.util.ArrayDeque;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-19 19:01
 * @version 1.0
 */
public class Classic052_Stack_Parenthess {
	public static void main(String[] args) {
		Classic052_Stack_Parenthess c52 = new Classic052_Stack_Parenthess();
		String s = "()[]{}";
		System.out.println(c52.isValid(s));
	}

	public boolean isValid(String s) {
		int len = s.length();
		if (len < 2)
			return false;
		ArrayDeque<Character> stack = new ArrayDeque<>();

		int i = 0;

		while (i < len) {
			if ('(' == s.charAt(i) || '[' == s.charAt(i) || '{' == s.charAt(i)) {
				stack.push(s.charAt(i));

			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					switch (s.charAt(i)) {
					case ')':
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							return false;
						}
						break;
					case ']':
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							return false;
						}
						break;
					case '}':
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							return false;
						}
						break;
					default:
						return false;
					}

				}
			}

			i++;

		}

		return stack.isEmpty();

	}
}
