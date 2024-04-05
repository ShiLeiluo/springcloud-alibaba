package com.fox.alibaba.leetcode150_01_Array_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-02-29 14:27
* @version 1.0
*/
public class Classic021_String_Reverse_DoublePointer {
	public static void main(String[] args) {
		Classic021_String_Reverse_DoublePointer cc02 = new Classic021_String_Reverse_DoublePointer();
		System.out.println(cc02.reverseWords("a  hello  world  "));
		
	}
	public String reverseWords(String s) {
		StringBuilder ans = new StringBuilder();
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = len-1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {

				if (sb.length() == 0) {
					continue;
				}

				if (ans.length() == 0) {
					ans.append(sb.reverse());
				}else {
					ans.append(" ").append(sb.reverse());
				}
				
				sb.setLength(0);
			}else {
				sb.append(s.charAt(i));
				if (i==0) {
					if (ans.length() == 0) {
						ans.append(sb.reverse());
					}else {
						ans.append(" ").append(sb.reverse());
					}
				}
			}
		}
		
		return ans.toString();
	}
	
	public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


}
