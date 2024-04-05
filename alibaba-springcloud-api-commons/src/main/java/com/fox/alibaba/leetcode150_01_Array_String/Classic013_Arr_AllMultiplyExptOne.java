package com.fox.alibaba.leetcode150_01_Array_String;

import java.util.Arrays;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-05 09:27
* @version 1.0
*/
//除自身以外的乘积
public class Classic013_Arr_AllMultiplyExptOne {
	public static void main(String[] args) {
		
		Classic013_Arr_AllMultiplyExptOne c94 = new Classic013_Arr_AllMultiplyExptOne();
		
		int[] nums = {1,2,3,4};
		
		System.out.println(Arrays.toString(c94.productExceptSelf(nums)));
	}
	
	public int[] productExceptSelf(int[] nums) {
		
		int len = nums.length;
		
		int[] answer = new int[len];
		
		//L[i]左侧乘积列表, R[i]右侧乘积列表
		int[] L = new int[len];
		int[] R = new int[len];
		
		
		//得到左侧乘积列表
		L[0] = 1;
		for (int i = 1; i < len; i++) {
			L[i] =  L[i-1] * nums[i-1];
		}
		
		
		//得到右边乘积列表
		R[len-1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			R[i] = R[i+1] * nums[i+1];
		}
		
		for (int i = 0; i < len; i++) {
			answer[i] = L[i] * R[i];
		}
		

		return answer;
	}
}
