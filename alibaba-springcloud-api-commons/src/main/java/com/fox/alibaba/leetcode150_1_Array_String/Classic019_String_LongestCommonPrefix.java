package com.fox.alibaba.leetcode150_1_Array_String;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-28 11:26
* @version 1.0
*/
public class Classic019_String_LongestCommonPrefix {
	public static void main(String[] args) {
		Classic019_String_LongestCommonPrefix cc01 = new Classic019_String_LongestCommonPrefix();
		String[] strs = {"flower","flow","flight"};
		System.out.println(cc01.longestCommonPrefix(strs));
	}
	
	//依次比较两个字符串的最长公共前缀至tempPrefix, 并更新
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		//
		String ans = strs[0];

		for (int i = 1; i < strs.length; i++) {
			ans = getLongestCommonPrefix(ans, strs[i]);
			if (ans.length() == 0) {
				return "";
			}
		}
		
		return ans;
	}
	
	private String getLongestCommonPrefix(String str1, String str2) {
		int len = Math.min(str1.length(), str2.length());
		int index = 0;
		while(index < len) {
			if (str1.charAt(index) != str2.charAt(index)) {
				break;
			}
			index++;
		}
		
		return str1.substring(0, index);
	}
}
