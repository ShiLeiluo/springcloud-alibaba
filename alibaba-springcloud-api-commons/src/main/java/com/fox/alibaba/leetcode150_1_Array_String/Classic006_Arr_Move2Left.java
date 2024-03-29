package com.fox.alibaba.leetcode150_1_Array_String;

import java.util.Arrays;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-01 10:17
* @version 1.0
*/
//轮转数组
public class Classic006_Arr_Move2Left {
	public static void main(String[] args) {
		Classic006_Arr_Move2Left c6 = new Classic006_Arr_Move2Left();
		int nums[] = {1,2,3,4,5,6,7};
		int k = 3;
		
		c6.rotate(nums, k);
		
		System.out.println(Arrays.toString(nums));
	}
	
	
	//
	public void rotate(int nums[], int k) {
		int len = nums.length;
		int newNum[] = new int[len];
		for (int i = 0; i < nums.length; i++) {
			
			newNum[(i+k) % len] = nums[i];
		}
		System.arraycopy(newNum, 0, nums, 0, len);
	}
	
	//solution 3 翻转
	// reverse分三步
	// 原始    -->----->
	// 第一步  <-----<--
	// 第二步  -----><--
	// 第三步  ----->-->
}
