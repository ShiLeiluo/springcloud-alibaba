package com.fox.alibaba.leetcode150_3_SlidingWindow;

import java.util.HashSet;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-07 10:05
* @version 1.0
*/
public class Classic031_SlidingWindow_LongestSub {

	public static void main(String[] args) {
		Classic031_SlidingWindow_LongestSub c12 = new Classic031_SlidingWindow_LongestSub();
		String s = "a";
		System.out.println(c12.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int len = s.length();

		HashSet<Character> set = new HashSet<>();
		int start = 0, end = 0;
		
		int ans = 0;
		while(end<len) {
			while (set.contains(s.charAt(end))) {
				set.remove(s.charAt(start));
				start++;
			}
			ans = ans>(end-start+1)?ans:(end-start+1);
			set.add(s.charAt(end));
			end++;
		}
		
		return ans;
	}

}
