package com.fox.alibaba.leetcode150;

import java.util.Arrays;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-01-30 15:41
 * @version 1.0
 */
public class Classic001_Arr_Merge {

	public static void main(String[] args) {
		int[] nums1 = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;
		Classic001_Arr_Merge ca = new Classic001_Arr_Merge();
		ca.merge(nums1, m, nums2, n);
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {

			for(int i = 0; i < n; i++) {
				nums1[i] = nums2[i];
			}

			System.out.println(Arrays.toString(nums1));
			
		} else {

			int indexL = 0;
			int indexR = 0;
			for (int i = 0; i < n; i++) {
				for (int j = indexL; j < m; j++) {
					if (nums2[i] < nums1[j]) {
						indexL = j;
						indexR = m - 1;
						// 从j开始往右移
						while (indexL <= indexR) {
							nums1[indexR + 1] = nums1[indexR];
							indexR -= 1;
						}
						nums1[j] = nums2[i];
						break;
					}
					if (j == m - 1) {
						nums1[j + 1] = nums2[i];
					}
				}
				m += 1;
			}
			System.out.println(Arrays.toString(nums1));
		}
	}
}
