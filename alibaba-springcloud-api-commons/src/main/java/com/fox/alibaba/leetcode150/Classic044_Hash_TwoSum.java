package com.fox.alibaba.leetcode150;

import java.util.Arrays;
import java.util.HashMap;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-15 15:56
* @version 1.0
*/
public class Classic044_Hash_TwoSum {
	
	public static void main(String[] args) {
		Classic044_Hash_TwoSum c44 = new Classic044_Hash_TwoSum();
		int[] nums = {1,2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(c44.twoSum1(nums, target)));
	}
	//双指针
	//需要保证数组是自增的
	public int[] twoSum1(int[] nums, int target) {
		return null;
		
	}
	//Hash
	public int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> footPrint = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (footPrint.containsKey(target - nums[i])) {
				return new int[] {footPrint.get(target - nums[i]), i};
			}
			footPrint.put(nums[i], i);
		}
		
		return null;
		
	}
}
