package com.fox.alibaba.designPattern.creational.e5_prototype.deepClone;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 11:25
* @version 1.0
*/
public class TestMain {
	//访问类（深克隆的内存对象是不一致的）
	public static void main(String[] args) throws Exception {
		DeepProtoType p = new DeepProtoType();
		p.name = "宋江";
		p.deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");

		
		//方式1 完成深拷贝
		
		DeepProtoType p2 = (DeepProtoType) p.clone();
		
		System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
		System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());
	
		//方式2 完成深拷贝
		DeepProtoType p3 = (DeepProtoType) p.deepClone();
		
		System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
		System.out.println("p3.name=" + p.name + "p3.deepCloneableTarget=" + p3.deepCloneableTarget.hashCode());
	
	}

}
