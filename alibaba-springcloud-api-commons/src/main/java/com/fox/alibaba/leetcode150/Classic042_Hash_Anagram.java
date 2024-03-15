package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-15 10:08
* @version 1.0
*/
public class Classic042_Hash_Anagram {
	public static void main(String[] args) {
		Classic042_Hash_Anagram c42 = new Classic042_Hash_Anagram();
		System.out.println(c42.isAnagram("anagram", "nagarav"));
	}
	public boolean isAnagram(String s, String t) {
		
		int m = s.length();
		int n = t.length();
		if (m != n) return false;
		
		int[] sArr = new int[26];
		for (int i = 0; i < m; i++) {
			sArr[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < n; i++) {
			if(sArr[t.charAt(i)-'a'] < 1) {
				return false;
			}
			sArr[t.charAt(i)-'a']--;
		}
		
		return true;
	}
}
