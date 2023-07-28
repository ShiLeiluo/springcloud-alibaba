package com.fox.alibaba.test;

import java.math.BigDecimal;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-28 08:10
* @version 1.0
*/
public class StringTest {
	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(565656565656.0000);
		String valueOf = String.valueOf(bigDecimal);
		int indexOf = valueOf.indexOf("\\.");
		System.out.println(indexOf);
		System.out.println(valueOf.substring(0,valueOf.indexOf(".")));
	}
}
