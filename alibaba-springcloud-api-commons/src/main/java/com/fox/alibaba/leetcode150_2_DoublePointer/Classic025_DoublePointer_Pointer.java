package com.fox.alibaba.leetcode150_2_DoublePointer;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-04 10:51
* @version 1.0
*/
public class Classic025_DoublePointer_Pointer {
	public static void main(String[] args) {
		Classic025_DoublePointer_Pointer cc05 = new Classic025_DoublePointer_Pointer();
		
		System.out.println(cc05.isPalindrome1("A mAs"));
	}
	
	public boolean isPalindrome1(String s) {
		
		StringBuilder sb = new StringBuilder();
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (isLetterOrDigit(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		int left = 0, right = sb.length() - 1;
		
		while (left < right) {
			
			if (sb.charAt(left) != sb.charAt(right)) {
				return false;
			}
			
			left++;
			right--;
			
		}
		
		return true;
	}
	private boolean isLetterOrDigit(char c) {
		if ((c>'a' && c<'z') || (c>'0' && c<'9')) {
			return true;
		}
		return false;
	}
	
	public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
		}
		String sbReverse = sb.toString();

		if (sbReverse.equals(sb.reverse().toString())) {
			
			return true;
		}
		System.out.println(sb);
		
		return false;
		
	}
}
