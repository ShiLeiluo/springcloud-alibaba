package com.fox.alibaba.utils;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-20 18:07
* @version 1.0
*/
public class KPM {
	public static void main(String[] args) {
		String str1 = "ababab";
		String str2 = "ababababr";
		int count = 0;
		int m = str1.length();
		int n = str2.length();
		int[] next = new int[m];
		
		getNext(next, str1);
		
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (j>0 && str2.charAt(i) != str1.charAt(j)) {
				j = next[j-1];
			}
			if (str2.charAt(i) == str1.charAt(j)) {
				j++;
			}
			if (j == m) {
				
				count += 1;
				j = next[j-1];
				System.out.println("count: " + count + " idx: "+ i + " "+str2.substring(i-m+1,i+1));
			}
		}
	}
	public static void getNext(int[] next, String str) {
		int j = 0;
		next[0] = j;
		
		for (int i = 1; i < next.length; i++) {
			while (j>0 && str.charAt(i) != str.charAt(j)) {
				j = next[j-1];
			}
			if (str.charAt(i) == str.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
	}
}
