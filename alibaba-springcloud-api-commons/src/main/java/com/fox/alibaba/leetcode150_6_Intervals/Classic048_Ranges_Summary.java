package com.fox.alibaba.leetcode150_6_Intervals;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-16 19:27
* @version 1.0
*/
public class Classic048_Ranges_Summary {
	public static void main(String[] args) {
		Classic048_Ranges_Summary c48 = new Classic048_Ranges_Summary();
		int nums[] = {0,2,3,4,6,8,9};
		System.out.println(c48.summaryRanges_leetCode(nums));
	}

	//分组循环
	public List<String> summaryRanges_leetCode(int[] nums){
		List<String> ansList = new ArrayList<>();
		int i = 0;
		int n = nums.length;
		while(i<n) {
			int low = i;
			i++;
			while(i<n && nums[i-1] + 1 == nums[i]) {
				i++;
			}
			int high = i-1;
			StringBuilder sb = new StringBuilder(Integer.toString(low));
			if (low<high) {
				sb.append("->");
				sb.append(high);
			}
			ansList.add(sb.toString());
		}
		
		
		return ansList;
	}
	
	public List<String> summaryRanges(int[] nums){
		List<String> ansList = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int stratIndex = i;
			if (i==nums.length-1) {
				ansList.add(String.valueOf(nums[i]));
				break;
			}
			while(nums[i]+1==nums[i+1]) {
				i++;
				if (i == nums.length-1) {
					ansList.add(nums[stratIndex]+"->"+nums[i]);
					break;
				}
			}
			if (i == nums.length-1) {
				break;
			}
			if (stratIndex == i) {
				ansList.add(String.valueOf(nums[i]));
			}else{
				ansList.add(nums[stratIndex]+"->"+nums[i]);
			}

		}
		
		return ansList;
	}
}
