package com.fox.alibaba.designPattern.creational.a1_factory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 08:32
* @version 1.0
*/
public class PythonCourseFactory implements CourseFactory {

	@Override
	public Course creatCourse() {
		// TODO Auto-generated method stub
		PythonCourse pythonCourse = new PythonCourse();
		return pythonCourse;
	}

}
