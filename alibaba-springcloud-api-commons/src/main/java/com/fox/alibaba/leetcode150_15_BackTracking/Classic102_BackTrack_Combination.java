package com.fox.alibaba.leetcode150_15_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-05-31 15:09
 * @version 1.0
 */
public class Classic102_BackTrack_Combination {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		Classic102_BackTrack_Combination c102 = new Classic102_BackTrack_Combination();

		List<List<Integer>> permute = c102.permute(nums);

		for (int i = 0; i < permute.size(); i++) {
			System.out.println(permute.get(i).toString());
		}
	}

	int[] flag;
	List<List<Integer>> combines = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {
		flag = new int[nums.length];
		backtrack(nums, new ArrayList<>());
		
		return combines;
	}

	public void backtrack(int[] nums, List<Integer> combine) {
		if (combine.size() == nums.length) {
			combines.add(new ArrayList<>(combine));
			return;
		}

		
		for (int i = 0; i < nums.length; i++) {
			if (flag[i] == 0) {
				combine.add(nums[i]);
				flag[i] = 1;
				backtrack(nums, combine);
				flag[i] = 0;
				combine.remove(combine.size() - 1);
			}
			
		}
		
	}
}
