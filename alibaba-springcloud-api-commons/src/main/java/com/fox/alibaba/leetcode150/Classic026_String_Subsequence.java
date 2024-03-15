package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-04 14:20
* @version 1.0
*/
public class Classic026_String_Subsequence {
	public static void main(String[] args) {
		Classic026_String_Subsequence c07 = new Classic026_String_Subsequence();
		String s = "";
		String t = "ahbgdc";
		System.out.println(c07.isSubsequence(s, t));
	}
	
	public boolean isSubsequence(String s, String t) {
		//从前往后匹配，可以发现每次贪心地匹配靠前的字符是最优决策。

		int sLen = s.length();
		if (sLen == 0) {
			return true;
		}
		int tLen = t.length();
		int i = 0, j =0;
		while(i<sLen && j<tLen) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				if (i == sLen) {
					return true;
					
				}
			}
			j++;
		}
		
		
		return false;
		
	}
	
	//Dynamic Programming
	public boolean isSubsequenceDP() {
		return false;
		
	}
}
