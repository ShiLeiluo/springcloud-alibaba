package com.fox.alibaba.designPattern.structural.f6_flyweight;

import java.util.HashMap;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 15:01
* @version 1.0
*/
public class DataSourceFactory {
	private static HashMap<String,DataSource> hashmap = new HashMap<>();
	
	public DataSourceFactory() {
		for (int i = 0; i < 10; i++) {
			DataSourceMaker dataSourceMaker = new DataSourceMaker(String.valueOf(i), "Datasource"+i);
			hashmap.put(dataSourceMaker.getDataId(), dataSourceMaker);
		}
	}
	
	public DataSource getDataSourceFactory(String dataSourceName) {
		if (hashmap.containsKey(dataSourceName)) {
			return hashmap.get(dataSourceName);
		}
		return null;
	}

}
