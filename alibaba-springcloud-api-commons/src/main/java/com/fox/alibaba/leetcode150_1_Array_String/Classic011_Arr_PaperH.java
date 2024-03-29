package com.fox.alibaba.leetcode150_1_Array_String;

import java.util.Arrays;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-03 15:18
* @version 1.0
*/
public class Classic011_Arr_PaperH {
	public static void main(String[] args) {
		Classic011_Arr_PaperH c92 = new Classic011_Arr_PaperH();
		int[] citations = {13,13,13,14,4};
		System.out.println(c92.hIndex(citations));
		
	}
	
	public int hIndex(int[] citations) {
		
		
		Arrays.sort(citations);

		int h = 0, i = citations.length - 1;
		while (i>=0 && citations[i] > h) {
			h++;
			i--;
			
		}
		
		return h;
		
	}
}
