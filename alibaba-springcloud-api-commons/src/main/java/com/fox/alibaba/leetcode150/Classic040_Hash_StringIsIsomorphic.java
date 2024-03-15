package com.fox.alibaba.leetcode150;

import java.util.HashMap;
import java.util.HashSet;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-14 15:03
* @version 1.0
*/
public class Classic040_Hash_StringIsIsomorphic {
	public static void main(String[] args) {
		Classic040_Hash_StringIsIsomorphic c40 = new Classic040_Hash_StringIsIsomorphic();

		System.out.println(c40.isIsomorphic("badc", "baba"));
		System.out.println(Integer.valueOf('1'));
	}

	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> mapping = new HashMap<>();
		HashSet<Character> tSet = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (mapping.containsKey(s.charAt(i))) {
				if (mapping.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}
			}else {
				if (tSet.contains(t.charAt(i))) {
					return false;
				}
				mapping.put(s.charAt(i), t.charAt(i));
				tSet.add(t.charAt(i));
			}
		}
		
		return true;
		
	}
}
