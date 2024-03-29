package com.fox.alibaba.leetcode150_2_DoublePointer;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-05 08:46
 * @version 1.0
 */
public class Classic028_DoublePointer_MaxWater {
	public static void main(String[] args) {
		Classic028_DoublePointer_MaxWater c09 = new Classic028_DoublePointer_MaxWater();
		int[] height = { 1, 3, 2, 5, 25, 24, 5 };// 24
		System.out.println(c09.maxArea(height));

	}

	public int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;

		int ans = 0;

		while (left < right) {
			int maxArea = (right - left) * (Math.min(height[left], height[right]));
			ans = Math.max(ans, maxArea);
			if (height[left] <= height[right]) {

				left++;
			} else {
				right--;
			}

		}

		return ans;
	}
	//1, 3, 2, 5, 25, 24, 5
	public int maxArea1(int[] height) {
		int l = 0, r = height.length - 1;
		int ans = 0;
		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			ans = Math.max(ans, area);
			if (height[l] <= height[r]) {
				++l;
			} else {
				--r;
			}
		}
		return ans;
	}

}
