package com.fox.alibaba.leetcode150_7_Satck;

import java.nio.file.Paths;

/**
 * @author F1337248 ShiLeiluo
 * @date 2024-03-19 20:02
 * @version 1.0
 */
public class Classic053_Stack_SimplifyPath {
	public static void main(String[] args) {
		Classic053_Stack_SimplifyPath c53 = new Classic053_Stack_SimplifyPath();
		String path = "/a/./b/../../c/";
		System.out.println(c53.simplifyPath(path));
	}

	public String simplifyPath(String path) {
		return Paths.get(path).normalize().toString();

	}
}
