package com.fox.alibaba.algorithm;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-28 15:56
* @version 1.0
*/
public class LongestCommon_Practise {
	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "qwerbcdeqwer";
		System.out.println("str1:"+str1);
		System.out.println("str2:"+str2);
		
		int m = str1.length() + 1;
		int n = str2.length() + 1;
		int max = Integer.MIN_VALUE;
		int idx = 0;
		int[][] dp = new int[m][n];
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				if(dp[i][j] > max) {
					max = dp[i][j];
					idx = i;
				}
			}
		}
		
		System.out.println(str1.substring(idx-max, idx));
		
	}
	
	
}
