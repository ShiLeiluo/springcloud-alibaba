package com.fox.alibaba.leetcode150;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-02-01 16:20
 * @version 1.0
 */
public class Classic007_Arr_StockMaxProfit {
	public static void main(String[] args) {
		Classic007_Arr_StockMaxProfit c7 = new Classic007_Arr_StockMaxProfit();
		int prices[] = { 7, 6, 4, 3, 1 };
		System.out.println(c7.maxProfit(prices));

	}

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}else {
				maxProfit = maxProfit>prices[i]-minPrice?maxProfit:prices[i]-minPrice;
			}
		}
		return maxProfit;
	}
}
