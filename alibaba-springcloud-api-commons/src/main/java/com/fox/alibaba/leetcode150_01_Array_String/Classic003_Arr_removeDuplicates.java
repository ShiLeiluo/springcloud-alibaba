package com.fox.alibaba.leetcode150_01_Array_String;

import java.util.Arrays;

/**
* @author F1337248 ShiLeiluo
* @date 2024-01-31 10:04
* @version 1.0
*/
public class Classic003_Arr_removeDuplicates {
	public static void main(String[] args) {
		Classic003_Arr_removeDuplicates c3 = new Classic003_Arr_removeDuplicates();
		int[] nums = {1,1,2};
		System.out.println(c3.removeDuplicates(nums));
		
	}
    public int removeDuplicates(int[] nums) {
    	int val = nums[0];
    	int idx = 1;
    	for (int i = 1; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[idx] = nums[i];
				idx += 1;
				val = nums[i];
			}
		}
    	System.out.println(Arrays.toString(nums));
		return idx;

    }
}
