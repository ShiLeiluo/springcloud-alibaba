package com.fox.alibaba.leetcode150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-04 17:19
* @version 1.0
*/
public class Classic027_Arr_Sum {
	public static void main(String[] args) {
		Classic027_Arr_Sum c08 = new Classic027_Arr_Sum();
		int numbers[] = {2,3,4};
		int target = 6;
		System.out.println(Arrays.toString(c08.twoSum2(numbers, target)));
	}
	public int[] twoSum(int[] numbers, int target) {
		//双指针, 数组是递增的, 左指针和右指针相加, 
		//它们的和小于target, 左指针移动
		//大于target, 右指针移动
		int left = 0;
		int right = numbers.length - 1;
		while(left < right) {
			if (numbers[left] + numbers[right] == target) {
				return new int[] {left+1, right+1};
			}else if(numbers[left] + numbers[right] > target){
				right--;
			}else {
				left++;
			}
		}
		
		return null;
		
	}
	
	public int[] twoSum1(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i]+numbers[j] == target) {
					return new int[]{i+1, j+1};
				}
			}
		}
		return null;
		
	}
	
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashTable = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			if (hashTable.containsKey(target-nums[i])) {
				return new int[]{hashTable.get(target-nums[i])+1, i+1};
			}
			hashTable.put(nums[i], i);
		}
		return null;
		
	}
	
}
