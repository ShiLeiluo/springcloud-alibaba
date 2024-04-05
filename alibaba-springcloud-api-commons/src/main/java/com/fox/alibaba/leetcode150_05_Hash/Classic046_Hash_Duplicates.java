package com.fox.alibaba.leetcode150_05_Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-15 16:34
 * @version 1.0
 */
public class Classic046_Hash_Duplicates {
	public static void main(String[] args) {
		Classic046_Hash_Duplicates c46 = new Classic046_Hash_Duplicates();
		int[] nums = { 1,2,3,1,2,3 };
		int k = 2;
		System.out.println(c46.containsNearbyDuplicates(nums, k));

		System.out.println("compute, computeIfAbsent, computeIfPresent");
		HashMap<Integer, List<Integer>> maps1 = new HashMap<>();
		HashMap<Integer, List<Integer>> maps2 = new HashMap<>();
		HashMap<Integer, List<Integer>> maps3 = new HashMap<>();
		ArrayList<Integer> a1 = new ArrayList<>(); a1.add(1);
		maps1.put(1, a1);
		ArrayList<Integer> a2 = new ArrayList<>(); a2.add(1);
		maps2.put(1, a2);
		ArrayList<Integer> a3 = new ArrayList<>(); a3.add(1);
		maps3.put(1, a3);
		
		
		

		maps1.keySet().stream().forEach(key -> {
			System.out.println("compute: "+key+"-"+maps1.get(key));
		});
		maps2.keySet().stream().forEach(key -> {
			System.out.println("computeIfAbsent: "+key+"-"+maps2.get(key));
		});
		maps3.keySet().stream().forEach(key -> {
			System.out.println("computeIfPresent: "+key+"-"+maps3.get(key));
		});

	}

	public boolean containsNearbyDuplicates(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;}
}
