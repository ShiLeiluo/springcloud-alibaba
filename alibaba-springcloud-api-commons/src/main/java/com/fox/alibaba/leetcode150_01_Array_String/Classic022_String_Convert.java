package com.fox.alibaba.leetcode150_01_Array_String;

import java.util.ArrayList;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-29 15:37
* @version 1.0
*/
public class Classic022_String_Convert {
	public static void main(String[] args) {
		Classic022_String_Convert c03 = new Classic022_String_Convert();
		System.out.println(c03.convert("AB", 1));
	}
	public String convert(String s, int numRows) {
		if (numRows < 2) {
			return s;
		}
		ArrayList<StringBuilder> rows = new ArrayList<>();
		
		
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		
		int i = 0, flag = -1;
		for (char c : s.toCharArray()) {
			rows.get(i).append(c);
			if (i == 0 || i == numRows - 1) {
				flag = -flag;
			}
			i += flag;
		}
		
//		StringBuilder res = new StringBuilder();
//		for (StringBuilder row : rows) {
//			res.append(row);
//		}
		
		return String.join("",rows);
	}
}
