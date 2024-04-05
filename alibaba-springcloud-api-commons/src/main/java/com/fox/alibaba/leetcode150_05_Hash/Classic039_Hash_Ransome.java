package com.fox.alibaba.leetcode150_05_Hash;

import java.util.HashMap;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-14 11:14
* @version 1.0
*/
public class Classic039_Hash_Ransome {
	public static void main(String[] args) {
		Classic039_Hash_Ransome c39 = new Classic039_Hash_Ransome();
		System.out.println(c39.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
	}
	
	public boolean canConstruct(String ransomNote, String magazine) {
		//ransomNote能不能由magazine里面的字符构成
		
		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0)+1);
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (magazineMap.containsKey(ransomNote.charAt(i))) {
				int v = magazineMap.get(ransomNote.charAt(i));
				v -= 1;
				if (v<1) {
					magazineMap.remove(ransomNote.charAt(i));
				}else {
					magazineMap.put(ransomNote.charAt(i), v);
				}
			}else {
				return false;
			}
		}
		
		return true;
	}
}
