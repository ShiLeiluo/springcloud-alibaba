package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-01 14:07
* @version 1.0
*/
public class Classic023_String_NextArr {
	
	public static void main(String[] args) {
		Classic023_String_NextArr cc04 = new Classic023_String_NextArr();
		
		System.out.println(cc04.strStr("mississippi", "issip"));

	}
	
	public int strStr(String haystack, String needle) {
		int m = haystack.length();
		int n = needle.length();
		
		int[] next = new int[n];
		getNext(next, needle);
		int j = 0;
		for (int i = 0; i < m; i++) {
			while (j>0 && haystack.charAt(i) != needle.charAt(j)) {
				
				j = next[j-1];
			}
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}
			if (j==n) {
				return i + 1 - n;
			}
		}
		
		
		return -1;
		
	}
	
	//构建查找目标的next[]数组, 
	private void getNext(int[] next, String str) {
		
		int j = 0;
		next[0] = j;
		
		for (int i = 1; i < str.length(); i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j)) {
				j = next[j-1];
			}
			
			if (str.charAt(i) == str.charAt(j)) {
				j++;
			}
			
			next[i] = j;
		}

		
	}
}
