package com.fox.alibaba.designPattern.creational.a1_factory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 08:33
* @version 1.0
*/
public class TestMain {
	public static void main(String[] args) {
		Course javaCourse = new JavaCourseFactory().creatCourse();
		javaCourse.record();
		Course pythonCourse = new PythonCourseFactory().creatCourse();
		pythonCourse.record();
	}
}
