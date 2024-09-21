package com.fox.alibaba.leetcode150_14_DictTree;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-17 08:50
* @version 1.0
*/
public class Classic098_DictTree_AddSearch {
	
	public static void main(String[] args) {
		String s = "awor.";
		
		// ^ 匹配行的开始, 必须以什么开始
		// $ 匹配行的结束, 必须以什么结束
		String regex = "^.*w..[a-zA-Z\\.].*$";
		System.out.println(s.matches(regex));
		
		Classic098_DictTree_AddSearch c98 = new Classic098_DictTree_AddSearch();
		c98.addWord("bad");
		c98.addWord("dad");
		c98.addWord("mad");
		boolean a = c98.search("pad"); // 返回 False
		boolean b = c98.search("bad"); // 返回 True
		boolean c = c98.search(".ad"); // 返回 True
		boolean d = c98.search("b.."); // 返回 True
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	private String s = ",";
    public Classic098_DictTree_AddSearch() {
    	
    }
    
    public void addWord(String word) {
    	s = s + word + ",";
    }
    
    public boolean search(String word) {
    	StringBuilder regex = new StringBuilder();
    	
    	
    	char[] charArray = word.toCharArray();
    	regex.append("^.*,");
    	for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '.') {
				regex.append("[a-z\\.]");
			}else {
				regex.append("[").append(charArray[i]).append("\\.]");
			}
		}
    	regex.append(",.*$");
    	if (s.matches(regex.toString())) {
    		return true;
		}
		return false;

    }
}
