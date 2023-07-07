package com.fox.alibaba.designPattern.creational.a1_factory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 08:29
* @version 1.0
*/
public class JavaCourseFactory implements CourseFactory {

	@Override
	public Course creatCourse() {
		// TODO Auto-generated method stub
		JavaCourse javaCourse = new JavaCourse();
		return javaCourse;
	}
	
}
