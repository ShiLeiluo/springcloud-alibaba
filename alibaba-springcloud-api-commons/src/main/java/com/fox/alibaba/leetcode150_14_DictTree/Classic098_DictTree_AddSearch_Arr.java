package com.fox.alibaba.leetcode150_14_DictTree;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-23 16:51
* @version 1.0
*/
public class Classic098_DictTree_AddSearch_Arr {

	
	public static void main(String[] args) {
		String s = "awor.";
		
		// ^ 匹配行的开始, 必须以什么开始
		// $ 匹配行的结束, 必须以什么结束
		String regex = "^.*w..[a-zA-Z\\.].*$";
		System.out.println("test: "+s.matches(regex));
		
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
	
    private Trie root;

    public Classic098_DictTree_AddSearch_Arr() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        root.insert(word);
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie node) {
        if (index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if (Character.isLetter(ch)) {
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                Trie child = node.getChildren()[i];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }

}
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
