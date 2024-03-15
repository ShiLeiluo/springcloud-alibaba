package com.fox.alibaba.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-05 14:45
 * @version 1.0
 */
public class Classic029_Arr_ThreeSum_DoublePointer {
	public static void main(String[] args) {
		Classic029_Arr_ThreeSum_DoublePointer c10 = new Classic029_Arr_ThreeSum_DoublePointer();
		int[] sums = { -1, 0, 1, 2, -1, -4 };

		System.out.println(c10.threeSum(sums));
		System.out.println(c10.threeSum1(sums));
		List<List<Integer>> anss = new ArrayList<List<Integer>>();
		List<Integer> ans1 = new ArrayList<>(3);
		ans1.add(1);
		ans1.add(2);
		ans1.add(3);
		List<Integer> ans2 = new ArrayList<>(3);
		ans2.add(2);
		ans2.add(1);
		ans2.add(3);
		List<Integer> ans3 = new ArrayList<>(3);
		ans3.add(1);
		ans3.add(2);
		ans3.add(3);
		anss.add(ans1);
		anss.add(ans2);
		anss.add(ans3);
		List<List<Integer>> collect = anss.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
	}
	// [nums[i], nums[j], nums[k]]
	// i != j、i != k 且 j != k
	// nums[i] + nums[j] + nums[k] == 0

	//双重for, 拿到
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> millionYuanList = new ArrayList<>();
		// 人都不够仨，还三胎。。。
		if (nums.length < 3) {
			return millionYuanList;
		}

		Arrays.sort(nums); // 孩子们按个头排好队
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			// 如果老大都大于0，后面的兄弟肯定都大于0，直接返回就行
			if (nums[i] > 0)
				break;
			Integer first = nums[i]; // 老大出列，站好别动
			System.out.println("first: "+first);
			// 老大想再往后占个位，多领一次奖，这可是不行滴。。。还是回家让妈妈再给生三个小弟弟吧^_^
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			// 画个圈，让各家老二在里面呆着
			Set<Integer> set = new HashSet<>();
			for (int j = i + 1; j < nums.length; j++) {
				// 老三出列，一会你和老大一块到圈里找老二
				int third = nums[j];
				System.out.println("third: "+third);
				int second = -(first + third); // 目标是：老大 + 老二 + 老三 = 0
				System.out.println("second: "+second);
				// 找到老二了，记到中奖名单上
				System.out.println("set: "+set.toString());
				if (set.contains(second)) {
					millionYuanList.add(new ArrayList<>(Arrays.asList(first, third, -(first + third))));

					// 老三也想多领奖。。。额。。。等会一块回家找妈妈去吧
					while (j < nums.length - 1 && nums[j] == nums[j + 1])
						j++;
				}
				set.add(third);
				
			}
		}
		return millionYuanList;
	}

	// 我操, 看我三重for暴力解法

	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> anss = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {

					if (nums[i] + nums[j] + nums[k] == 0) {

						List<Integer> ans = new ArrayList<>(3);
						ans.add(nums[i]);
						ans.add(nums[j]);
						ans.add(nums[k]);
						anss.add(ans);
					}
				}
			}
		}
		return anss;
//		return anss.stream().distinct().collect(Collectors.toList());
	}
}
