package com.fox.alibaba.leetcode150_1_Array_String;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-02 15:27
* @version 1.0
*/
public class Classic010_Arr_Jump2 {
	public static void main(String[] args) {
		Classic010_Arr_Jump2 c91 = new Classic010_Arr_Jump2();
		int[] nums = {2,3,1,1,4};
		System.out.println(c91.jump(nums));
	}
	
	public int jump(int[] nums) {
		
		int position = nums.length - 1;
		int steps = 0;
		
		while(position > 0) {
			
			for (int i = 0; i < nums.length; i++) {
				if (i + nums[i] >= position) {
					position = i;
					steps++;
					break;
				}
			}

		}
		
		return steps;
		
	}
	
	public int jump2(int nums[]) {
		int steps = 0;
		int maxPosition = 0;
		int end = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			maxPosition = i + nums[i] > maxPosition ? i + nums[i] : maxPosition;
			if (i == end) {
				end = maxPosition;
				steps++;
			}
			
		}
		
		return steps;
		
	}
}
