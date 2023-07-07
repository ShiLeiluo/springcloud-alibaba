package com.fox.alibaba.designPattern.creational.d4_builder;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 11:14
* @version 1.0
*/
/**
 * 组装类--将Build构建的产品部件组装成产品, 对外隐藏产品组装细节
 * @author F1337248
 *
 */
public class Director {
	
	private Builder mBuilder;
	
	public Director(Builder mBuilder) {
		// TODO Auto-generated constructor stub
		this.mBuilder = mBuilder;
	}
	
	public void construct(String board, String display, String os) {
		mBuilder.setBoard(board);
		mBuilder.setDisplay(display);
		mBuilder.setOs(os);
	}
}
