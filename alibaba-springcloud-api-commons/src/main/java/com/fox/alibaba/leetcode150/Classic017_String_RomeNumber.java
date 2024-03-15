package com.fox.alibaba.leetcode150;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-02-21 14:21
 * @version 1.0
 */
public class Classic017_String_RomeNumber {
	public static void main(String[] args) {
		String[] strings = { "III", "IV", "IX", "LVIII", "MCMXCIV" };
		Classic017_String_RomeNumber c98 = new Classic017_String_RomeNumber();
		for (int i = 0; i < strings.length; i++) {
			System.out.println(c98.romeToInt(strings[i]));
		}
	}

//	字符          数值
//	I             1
//	V             5
//	X             10
//	L             50
//	C             100
//	D             500
//	M             1000
//	I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//	X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//	C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
	public int romeToInt(String s) {

		char[] charArray = s.toCharArray();
		int ans = 0;
		int len = charArray.length;
		for (int i = 0; i < len; i++) {
			switch (charArray[i]) {
			case 'I':
				if (i == len-1 || (charArray[i+1] != 'V' && charArray[i+1] != 'X')) {
					ans += 1;
				}else if (charArray[i+1] == 'V') {
					ans += 4;
					i++;
				}else {
					ans += 9;
					i++;
				}
				break;
			case 'V':
				ans += 5;
				break;
			case 'X':
				if (i == len-1 || (charArray[i+1] != 'L' && charArray[i+1] != 'C')) {
					ans += 10;
				}else if (charArray[i+1] == 'L') {
					ans += 40;
					i++;
				}else {
					ans += 90;
					i++;
				}
				break;
			case 'L':
				ans += 50;
				break;
			case 'C':
				if (i == len-1 || (charArray[i+1] != 'D' && charArray[i+1] != 'M')) {
					ans += 100;
				}else if (charArray[i+1] == 'D') {
					ans += 400;
					i++;
				}else {
					ans += 900;
					i++;
				}
				break;
			case 'D':
				ans += 500;
				break;
			case 'M':
				ans += 1000;
				break;
			default:
				break;
			}
		}

		return ans;

	}
}
