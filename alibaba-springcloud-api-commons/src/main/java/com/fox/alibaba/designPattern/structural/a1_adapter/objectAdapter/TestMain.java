package com.fox.alibaba.designPattern.structural.a1_adapter.objectAdapter;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 15:11
* @version 1.0
*/
public class TestMain {
	public static void main(String[] args) {
		PowerAdapter powerAdapter = new PowerAdapter(new AC220());
		powerAdapter.output5V();
	}
}
