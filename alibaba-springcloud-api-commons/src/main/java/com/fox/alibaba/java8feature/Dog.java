package com.fox.alibaba.java8feature;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-08-09 15:37
 * @version 1.0
 */
public class Dog {
	private int age;
	private String name;
	
	public Dog() {}
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	
	
}
