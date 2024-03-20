package com.fox.alibaba.leetcode150;

import java.util.Arrays;
import java.util.HashSet;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-16 17:21
* @version 1.0
*/
public class Classic047_Hash_Arr {
	public static void main(String[] args) {
		Classic047_Hash_Arr c47 = new Classic047_Hash_Arr();
		int[] num = {1,2,0,1};
		System.out.println(c47.longestConsecutive(num));
	}
	
	
	public int longestConsecutive(int[] nums) {
		int len = nums.length;
		if (len==0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<>();
		
		Arrays.stream(nums).forEach(a->set.add(a));
		
		int longestStreak = 0;
		
		for (int num : set) {
			if (!set.contains(num-1)) {
				int currentNum = num;
				int currentStreak = 1;
				while(set.contains(currentNum+1)) {
					currentNum += 1;
					currentStreak += 1;
					
				}
				longestStreak = longestStreak>currentStreak?longestStreak:currentStreak;
			}
		}
		
		return longestStreak;
		
	}
}
