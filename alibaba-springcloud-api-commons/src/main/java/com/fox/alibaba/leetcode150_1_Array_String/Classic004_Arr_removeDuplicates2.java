package com.fox.alibaba.leetcode150_1_Array_String;

import java.util.Arrays;

/**
* @author F1337248 ShiLeiluo
* @date 2024-01-31 13:47
* @version 1.0
*/
public class Classic004_Arr_removeDuplicates2 {
	public static void main(String[] args) {
		Classic004_Arr_removeDuplicates2 c4 = new Classic004_Arr_removeDuplicates2();
		int nums[] = {1,1,1,2,2,3};
		
		System.out.println(c4.removeDuplicates(nums));
	}
	
	public int removeDuplicates(int nums[]) {
		int numsLength = nums.length;
		if (numsLength < 3) {
			return numsLength;
		}
		
		int val = nums[1];
		int idx = 2;
		for (int i = 2; i < numsLength; i++) {
			if (nums[i] == val) {
				if (nums[idx-2] != val) {
					nums[idx] = nums[i];
					val = nums[i];
					idx += 1;
				}
			}else {
				nums[idx] = nums[i];
				val = nums[i];
				idx += 1;
			}
		}
		
		System.out.println(Arrays.toString(nums));
		return idx;
		
	}
}
