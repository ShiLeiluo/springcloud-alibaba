package com.fox.alibaba.algorithm;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-20 17:55
* @version 1.0
*/
public class LongestCommon {
	public static void main(String[] args) {
		String str1 = "i adore you";
		String str2 = "maybe i adore you probably";
		System.out.println(getLongCommon(str1, str2));
	}
	
	public static String getLongCommon(String str1, String str2) {
		
		int m = str1.length() + 1;
		int n = str2.length() + 1;
		
		int[][] dp = new int[m][n];
		
		int max=0,idx=0;
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				if (dp[i][j] > max) {
					max = dp[i][j];
					idx = i;
				}
				
			}
		}
		
		
		return str1.substring(idx-max,idx);
	}
}
