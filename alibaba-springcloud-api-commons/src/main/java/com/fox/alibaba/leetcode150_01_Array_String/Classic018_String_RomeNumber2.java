package com.fox.alibaba.leetcode150_01_Array_String;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-21 18:27
* @version 1.0
*/
public class Classic018_String_RomeNumber2 {
	public static void main(String[] args) {
		Classic018_String_RomeNumber2 c99 = new Classic018_String_RomeNumber2();

		int[] nums = {3,4,9,58,1994};
		for (int i = 0; i < nums.length; i++) {
			System.out.println(c99.intToRome(nums[i]));
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
	public String intToRome(int num) {
		
		String ans = "";
		
		
		String numS = String.valueOf(num);
		
		int len = numS.length();
		for (int i = len-1; i >= 0; i--) {
			if (i == len - 1) {
				
				ans = get1(numS.charAt(i)) + ans;
			}else if (i == len - 2) {
				ans = get2(numS.charAt(i)) + ans;
			}
			else if (i == len - 3) {
				ans = get3(numS.charAt(i)) + ans;
			}else if (i == len - 4) {
				ans = get4(numS.charAt(i)) + ans;
			}
		}
		
		
		return ans;
		
	}
	private String get1(char s) {

		String res = "";
		
		switch (s) {
		case '0':
			
			break;
		case '1':
			res = "I";
			break;
		case '2':
			res = "II";
			break;
		case '3':
			res = "III";
			break;
		case '4':
			res = "IV";
			break;
		case '5':
			res = "V";
			break;
		case '6':
			res = "VI";
			break;
		case '7':
			res = "VII";
			break;
		case '8':
			res = "VIII";
			break;
		case '9':
			res = "IX";
			break;

		default:
			break;
		}
		
		
		return res;
		
	}
	private String get2(char s) {

		String res = "";
		switch (s) {
		case '0':
			
			break;
		case '1':
			res = "X";
			break;
		case '2':
			res = "XX";
			break;
		case '3':
			res = "XXX";
			break;
		case '4':
			res = "XL";
			break;
		case '5':
			res = "L";
			break;
		case '6':
			res = "LX";
			break;
		case '7':
			res = "LXX";
			break;
		case '8':
			res = "LXXX";
			break;
		case '9':
			res = "XC";
			break;

		default:
			break;
		}
		
		
		return res;
		
	}
	private String get3(char s) {

		String res = "";
		switch (s) {
		case '0':
			
			break;
		case '1':
			res = "C";
			break;
		case '2':
			res = "CC";
			break;
		case '3':
			res = "CCC";
			break;
		case '4':
			res = "CD";
			break;
		case '5':
			res = "D";
			break;
		case '6':
			res = "DC";
			break;
		case '7':
			res = "DCC";
			break;
		case '8':
			res = "DCCC";
			break;
		case '9':
			res = "CM";
			break;

		default:
			break;
		}
		
		
		return res;
		
	}
	private String get4(char s) {

		String res = "";
		switch (s) {
		case '0':
			
			break;
		case '1':
			res = "M";
			break;
		case '2':
			res = "MM";
			break;
		case '3':
			res = "MMM";
			break;
		default:
			break;
		}
		
		
		return res;
		
	}
}
