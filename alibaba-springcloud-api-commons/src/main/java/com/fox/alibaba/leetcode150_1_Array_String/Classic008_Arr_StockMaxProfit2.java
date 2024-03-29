package com.fox.alibaba.leetcode150_1_Array_String;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-02-01 17:16
 * @version 1.0
 */
public class Classic008_Arr_StockMaxProfit2 {
	public static void main(String[] args) {
		Classic008_Arr_StockMaxProfit2 c8 = new Classic008_Arr_StockMaxProfit2();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(c8.maxProfit(prices));
	}

	// 拿到所有的上升期profit
	public int maxProfit(int[] prices) {
		
		int profit = 0;
		for (int i = 0; i < prices.length-1; i++) {
			
			if (prices[i] < prices[i+1]) {
				
				profit += prices[i+1]-prices[i];
			}
				
			
		}
		return profit;
		
	}
}
