package com.fox.alibaba.designPattern.structural.f6_flyweight;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 14:57
* @version 1.0
* 数据库连接生产者类1
*/
public class DataSourceMaker extends DataSource {

	public DataSourceMaker(String dataId, String dataName) {
		super(dataId, dataName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void method() {
		System.out.println("使用DataSourceMaker1生产数据库连接对象.....");
	}
}
