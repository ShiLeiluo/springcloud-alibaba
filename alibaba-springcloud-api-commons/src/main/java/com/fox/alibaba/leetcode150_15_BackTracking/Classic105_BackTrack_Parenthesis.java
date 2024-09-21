package com.fox.alibaba.leetcode150_15_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2024-06-04 16:22
* @version 1.0
*/
public class Classic105_BackTrack_Parenthesis {
	public static void main(String[] args) {
		Classic105_BackTrack_Parenthesis c105 = new Classic105_BackTrack_Parenthesis();
		int n = 3;

		List<String> generateParenthesis = c105.generateParenthesis(n);
		
		for (String parenthesis : generateParenthesis) {
			System.out.println(parenthesis);
		}
		
		
	}
	
    public List<String> generateParenthesis(int n) {
    	
    	List<String> parenthesis = new ArrayList<>();
    	char[] current = new char[n*2];
    	backtrack(parenthesis, current, 0);
		return parenthesis;
       
    }

    public void backtrack(List<String> parenthesis, char[] current, int pos) {
    	if (current.length == pos) {
    		if (isValid(current)) {
    			parenthesis.add(new String(current));
			}
			
		}else {
	    	current[pos] = '(';
	    	backtrack(parenthesis, current, pos + 1);
	    	current[pos] = ')';
	    	backtrack(parenthesis, current, pos + 1);
		}

    }
    
    private static boolean isValid(char[] current) {
		int balance = 0;
		for (char c : current) {
			if (c=='(') {
				balance += 1;
			}else {
				balance -= 1;
			}
			if (balance < 0) {
				return false;
			}
		}

    	return balance==0;
	}
    
}
