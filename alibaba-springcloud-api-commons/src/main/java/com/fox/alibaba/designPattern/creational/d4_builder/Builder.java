package com.fox.alibaba.designPattern.creational.d4_builder;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 10:42
* @version 1.0
*/
/**
 * 抽象Build--构建与产品相关的部件
 * @author F1337248
 *
 */
public abstract class Builder {
	
	/**
	 * 构建主机组件
	 */
	
	public abstract void setBoard(String mBoard);
	
	/**
	 * 构建显示器组件
	 */
	
	public abstract void setDisplay(String mDoisplay);
	
	/**
	 * 构建操作系统组件
	 */
	
	public abstract void setOs(String mOS);
	
	/**
	 * 构建产品
	 */
	
	public abstract Computer create();
}
