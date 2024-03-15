package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-01 18:40
* @version 1.0
*/
public class Classic009_Arr_Jump {
	public static void main(String[] args) {
		Classic009_Arr_Jump c9 = new Classic009_Arr_Jump();
		int nums[] = {0};
		System.out.println(c9.canJump(nums));
	}
	
	public boolean canJump(int nums[]) {
		int maxStep = 0;
		for (int i = 0; i < nums.length; i++) {
			maxStep = nums[i] > maxStep ? nums[i] : maxStep;

			if (maxStep == 0 && i < nums.length-1) {
				return false;
			}
			
			maxStep -= 1;
		}
		
		return true;
		
	}
	
	
}
