package com.fox.alibaba.leetcode150_01_Array_String;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-28 11:15
* @version 1.0
*/
public class Classic020_String_LastWordLength {
	public static void main(String[] args) {
		Classic020_String_LastWordLength cc00 = new Classic020_String_LastWordLength();
		System.out.println(cc00.lengthOfLastWord("luffy is still joyboy "));
	}
	public int lengthOfLastWord(String s) {
		
		s = s.trim();
		
		int lastIndexOf = s.lastIndexOf(" ");
		
		return s.length() - lastIndexOf - 1;
		
	}
}
