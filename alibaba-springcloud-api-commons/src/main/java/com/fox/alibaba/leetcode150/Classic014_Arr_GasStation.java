package com.fox.alibaba.leetcode150;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-05 16:41
* @version 1.0
*/
public class Classic014_Arr_GasStation {
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		Classic014_Arr_GasStation c95 = new Classic014_Arr_GasStation();
		System.out.println(c95.completeCircuit(gas, cost));
	}
	
//	JAVA，贪心算法一次遍历
//	因为如果存在解，则保证它是唯一的，所以一定是差值的最小前缀和的下一站。
//	如果总差值小于零，说明总油量不够行驶一周无解。
	public int completeCircuit(int[] gas, int[] cost) {
		
		int len = gas.length;
		int sum = 0;
		int min = 0;
		int idx = 0;
		for (int i = 0; i < len; i++) {
			sum += gas[i]-cost[i];
			if (sum < min) {
				min = sum;
				idx = i+1;
			}
		}
		
		return sum<0?-1:idx;
		
	}
}
