package com.fox.alibaba.designPattern.structural.f6_flyweight;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 14:52
* @version 1.0
* 
* 定义数据库连接资源基类 其他类需要继承此类
*/
public abstract class DataSource {
	
	String dataId;
	String dataName;
	
	public DataSource(String dataId, String dataName) {
		this.dataId = dataId;
		this.dataName = dataName;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public abstract void method();
	
	@Override
	public String toString() {
		return "Datasource [dataId=" + dataId + ", dataName=" + dataName + "]";
	}
	
	

}
