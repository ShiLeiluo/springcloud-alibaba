package com.fox.alibaba.leetcode150_15_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-29 16:35
* @version 1.0
*/
public class Classic101_BackTarck_NumberRange {
	public static void main(String[] args) {
		Classic101_BackTarck_NumberRange c101 = new Classic101_BackTarck_NumberRange();
		int n = 4;
		int k = 3;
		
		List<List<Integer>> combines = c101.combine(n, k);
		
		for (List<Integer> list : combines) {
			for (Integer num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	List<List<Integer>> combines = new ArrayList<>();
	public List<List<Integer>> combine(int n, int k){
		
		recursive(n, k, 1, new ArrayList<>());
		
		return combines;
	}
	
	public void recursive(int n, int k, int idx, List<Integer> combine) {
		if (combine.size() == k) {
			combines.add(new ArrayList<>(combine));
		}else {
			for (int i = idx; i <= n; i++) {
				combine.add(i);
				recursive(n, k, i + 1, combine);
				combine.remove(combine.size() - 1);
			}
		}
	}
	
}
