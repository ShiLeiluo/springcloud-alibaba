package com.fox.alibaba.leetcode150_01_Array_String;

import java.util.HashMap;
import java.util.Map;

/**
* @author F1337248 ShiLeiluo
* @date 2024-01-31 17:02
* @version 1.0
*/
public class Classic005_Arr_Mode {
	public static void main(String[] args) {
		Classic005_Arr_Mode c5 = new Classic005_Arr_Mode();
		int[] nums = {2,2,1,1,1,2,2};
		System.out.println(c5.majorityElement(nums));
	}
	
	
	// TODO: Mode = 众数 
	
	public int majorityElement(int nums[]) {
		HashMap<Integer,Integer> counts = countNums(nums);
		
		Map.Entry<Integer, Integer> majorityEntry = null;
		for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {

			if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
				majorityEntry = entry;
			}
		}
		
		return majorityEntry.getKey();
	}
	
	//将数组放入HashMap
	public HashMap<Integer, Integer> countNums(int nums[]){
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(counts.containsKey(nums[i])) {
				counts.put(nums[i], counts.get(nums[i])+1);
			}else {
				counts.put(nums[i],1);
			}
		}
		return counts;
	}
}
