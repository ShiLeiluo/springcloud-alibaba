package com.fox.alibaba.test;

import java.util.HashMap;

/**
* @author F1337248 ShiLeiluo
* @date 2024-03-28 15:24
* @version 1.0
*/
public class MapTest {
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>(2);
		
		map.put(1, 1);map.put(2, 4);map.put(3, 3);map.put(4, 4);
		System.out.println(map.size());
	}
}
