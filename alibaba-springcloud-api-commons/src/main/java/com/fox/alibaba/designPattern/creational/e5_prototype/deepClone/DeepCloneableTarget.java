package com.fox.alibaba.designPattern.creational.e5_prototype.deepClone;

import java.io.Serializable;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 11:23
* @version 1.0
*/
//引用类型
public class DeepCloneableTarget implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cloneName;

	private String cloneClass;

	//构造器
	public DeepCloneableTarget(String cloneName, String cloneClass) {
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}

	//因为该类的属性，都是String , 因此我们这里使用默认的clone完成即可
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

