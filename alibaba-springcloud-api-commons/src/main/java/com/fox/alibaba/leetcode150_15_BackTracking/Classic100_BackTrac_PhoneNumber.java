package com.fox.alibaba.leetcode150_15_BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-28 08:27
* @version 1.0
*/
public class Classic100_BackTrac_PhoneNumber {

	public static void main(String[] args) {
		Classic100_BackTrac_PhoneNumber c100 = new Classic100_BackTrac_PhoneNumber();
		
		String digits = "23";
		List<String> letterCombinations = c100.letterCombinations(digits);
		
		letterCombinations.stream().forEach(System.out::println);
	}
    public List<String> letterCombinations(String digits) {

    	List<String> combinations = new ArrayList<>();
    	
    	if (digits.length() == 0) {
			return combinations;
		}
    	Map<Character, String> map = new HashMap<>();
    	map.put('2', "abc");map.put('3', "def");
    	map.put('4', "ghi");map.put('5', "jkl");
    	map.put('6', "mno");map.put('7', "pqrs");
    	map.put('8', "tuv");map.put('9', "wxyz");

    	backtrack(combinations, map, digits, 0, new StringBuffer());
    	
    	return combinations;
    }
    public void backtrack(List<String> combinations, Map<Character, String> map, String digits, int index, StringBuffer combination) {
    	if (index == digits.length()) {
			combinations.add(combination.toString());
		}else {
			char key = digits.charAt(index);
			String value = map.get(key);
			
			char[] charArray = value.toCharArray();
			
			for (int i = 0; i < charArray.length; i++) {
				combination.append(charArray[i]);
				backtrack(combinations, map, digits, index + 1, combination);
				combination.deleteCharAt(index);
			}
		}
    	
    }
}
