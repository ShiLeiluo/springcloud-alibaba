package com.fox.alibaba.test;

import java.io.IOException;

import com.fox.test.HelloWord;
import com.fox.util.testProxy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-18 14:54
* @version 1.0
*/
public class HelloWordTest {
	public static void main(String[] args) {
		HelloWord helloWord = new HelloWord();
		helloWord.sayHello();
		System.setProperty("proxyHost", "10.191.131.15");  // 定义代理地址
		System.setProperty("proxyPort", "3128");          // 定义代理端口号
		testProxy testProxy = new testProxy();
		try {
			testProxy.testDJL();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
