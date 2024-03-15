package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-01-31 08:52
* @version 1.0
*/
public class Classic002_Arr_RemoveElement {
	public static void main(String[] args) {
		Classic002_Arr_RemoveElement c2 = new Classic002_Arr_RemoveElement();
		int nums[] = {0,1,2,2,3,0,4,2};
		int val = 2;
		System.out.println(c2.removeElement(nums, val));
	}
    public int removeElement(int[] nums, int val) {
        int res = 0;
        
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[res] = nums[i];
				res++;
			}
			
		}
        
		return res;
    }
}
