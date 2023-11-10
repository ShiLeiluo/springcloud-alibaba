package com.fox.alibaba.test;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-07 10:12
* @version 1.0
*/
public class SplitTest {
	public static void main(String[] args) {
		String sourcePath = "C:/Users/F1337248/Desktop/test";
		String picName = sourcePath.split("/")[3].split("\\.")[0];
		System.out.println(picName);
		System.out.println(sourcePath.split("\\.")[0]);
	}
}
