package com.fox.alibaba.leetcode150;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-07 16:05
* @version 1.0
*/
public class Classic033_String_MinWindow {
	public static void main(String[] args) {
		Classic033_String_MinWindow c33 = new Classic033_String_MinWindow();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(c33.minWindow(s, t));
	}
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();
	public String minWindow(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		if (tLen>sLen) {
			return "";
		}

		HashMap<Character, Integer> sMap = new HashMap<>();
		HashMap<Character, Integer> tMap = new HashMap<>();
		for (int i = 0; i < tLen; i++) {
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
		}

		int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        while (r < sLen) {
            ++r;
            if (r < sLen && tMap.containsKey(s.charAt(r))) {
            	sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check(tMap, sMap) && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }

                if (tMap.containsKey(s.charAt(l))) {
                	
                	sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
	}
    private boolean check(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        Iterator<Map.Entry<Character, Integer>> iter = tMap.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (sMap.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
    public String minWindow1(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check1() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                
                if (ori.containsKey(s.charAt(l))) {
                	
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check1() {
        Iterator<Map.Entry<Character, Integer>> iter = ori.entrySet().iterator(); 
        while (iter.hasNext()) { 
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) iter.next(); 
            Character key = (Character) entry.getKey(); 
            Integer val = (Integer) entry.getValue(); 
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        } 
        return true;
    }
}
