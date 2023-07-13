package com.fox.alibaba.designPattern.structural.f6_flyweight;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 15:08
* @version 1.0
*/
public class TestDataSource {
	public static void main(String[] args) {
		//取出数据库连接对象
		DataSourceFactory dataSourceFactory = new DataSourceFactory();
		for (int i = 0; i < 10; i++) {
			System.out.println("i: "+dataSourceFactory.getDataSourceFactory(String.valueOf(i)));
		}
	}
//	可以看到，享元模式的主旨在于构建一个池子的概念，需要使用对象的时候就从池子中去拿，
//	无需多次创建对象，在数据库连接池的实现中可以看到其身影。
	
}
