package com.fox.alibaba.leetcode150_01_Array_String;

import java.util.Arrays;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-06 09:41
* @version 1.0
*/
public class Classic015_Arr_Sugar {

	public static void main(String[] args) {
		Classic015_Arr_Sugar c96 = new Classic015_Arr_Sugar();
		int ratings[] = {1,3,4,5,2};
		System.out.println(c96.candy(ratings));
	}
	
	public int candy(int[] ratings) {
		int len = ratings.length;
		int nums[] = new int[len];
		Arrays.fill(nums, 1);

		// 从左至右
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			}
		}
		// 从右至左
		for (int i = len - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && nums[i] <= nums[i+1]) {
				nums[i] = nums[i + 1] + 1;
			}
		}
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += nums[i];
		}

		return sum;

	}
}
