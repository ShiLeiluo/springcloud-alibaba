package com.fox.alibaba.designPattern.creational.d4_builder;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-06-26 11:21
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {
		Builder builder = new ComputerBuilder();
		Director director = new Director(builder);
		director.construct("因特尔主板", "三星显示器", "windows");
		Computer computer1 = builder.create();

		System.out.println(computer1.getmBoard());
		
		Computer computer2 = new Computer.Builder()
				.setmBoard("AMD")
				.setmDisplay("TCL")
				.create();
		System.out.println(computer2.getmBoard());
	}
}
