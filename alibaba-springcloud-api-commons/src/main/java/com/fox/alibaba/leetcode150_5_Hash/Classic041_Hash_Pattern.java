package com.fox.alibaba.leetcode150_5_Hash;

import java.util.HashMap;
import java.util.HashSet;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-15 09:14
* @version 1.0
*/
public class Classic041_Hash_Pattern {
	public static void main(String[] args) {
		Classic041_Hash_Pattern c41 = new Classic041_Hash_Pattern();
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(c41.wordPattern(pattern, s));
	}
	
	public boolean wordPattern(String pattern, String s) {
		String[] sArr = s.split(" ");
		
		int m = pattern.length();
		int n = sArr.length;
		if (m!=n) return false;
		
		
		HashMap<Character, String> mapping = new HashMap<>();
		HashSet<String> sSet = new HashSet<>();
		for (int i = 0; i < m; i++) {
			if (mapping.containsKey(pattern.charAt(i))) {
				if (!mapping.get(pattern.charAt(i)).equals(sArr[i])) {
					return false;
				}
			}else {
				if (sSet.contains(sArr[i])) {
					return false;
				}
				mapping.put(pattern.charAt(i), sArr[i]);
				sSet.add(sArr[i]);
			}
		}
		
		
		return true;
	}
}
