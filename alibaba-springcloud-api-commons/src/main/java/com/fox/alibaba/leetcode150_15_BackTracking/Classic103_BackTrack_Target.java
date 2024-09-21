package com.fox.alibaba.leetcode150_15_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-06-04 16:22
* @version 1.0
*/
public class Classic103_BackTrack_Target {
	public static void main(String[] args) {
		Classic103_BackTrack_Target c103 = new Classic103_BackTrack_Target();
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> combinationSum = c103.combinationSum(candidates, target);
		
		combinationSum.stream().forEach(a->System.out.println(a.toString()));
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>(); // 状态（子集）
        Arrays.sort(candidates); // 对 candidates 进行排序
        int start = 0; // 遍历起始点
        List<List<Integer>> res = new ArrayList<>(); // 结果列表（子集列表）
        backtrack(state, target, candidates, start, res);
        return res;
    }
	
	public void backtrack(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target ，则直接结束循环
            // 这是因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target, start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack(state, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }
}
