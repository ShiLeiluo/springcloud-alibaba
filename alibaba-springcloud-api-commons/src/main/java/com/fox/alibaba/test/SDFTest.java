package com.fox.alibaba.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
* @author F1337248 ShiLeiluo
* @date 2023-10-23 09:11
* @version 1.0
*/
public class SDFTest {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a", Locale.ENGLISH);
		String format = sdf.format(new Date());
		System.out.println(format);
	}
}
