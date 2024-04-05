package com.fox.alibaba.leetcode150_03_SlidingWindow;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-06 13:57
 * @version 1.0
 */
public class Classic030_SlidingWindow_SubSum {
	public static void main(String[] args) {
		Classic030_SlidingWindow_SubSum c11 = new Classic030_SlidingWindow_SubSum();
		int target = 15;
		int[] nums = { 5, 1, 3, 5, 10, 7, 4, 9, 2, 8 };

		System.out.println(c11.minSubArrayLen1(target, nums));
	}

	// 暴力解法
	public int minSubArrayLen(int target, int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			if (temp >= target) {
				return 1;
			}
			for (int j = i + 1; j < nums.length; j++) {
				temp += nums[j];
				if (temp >= target) {
					if (ans != 0) {
						ans = ans < (j - i + 1) ? ans : (j - i + 1);
					} else {
						ans = j - i + 1;
					}

				}
			}
		}

		return ans;

	}

	// 滑动窗口
	public int minSubArrayLen1(int target, int[] nums) {
		int ans = Integer.MAX_VALUE;
		
		int start = 0, end = 0;
		
		int len = nums.length;
		
		int sum = 0;
		while(end < len) {
			sum += nums[end];
			while(sum>=target) {
				ans = ans<(end-start+1)?ans:(end-start+1);
				sum -= nums[start];
				start++;
			}
			end++;
		}
		
		return ans == Integer.MAX_VALUE?0:ans;

	}
}
