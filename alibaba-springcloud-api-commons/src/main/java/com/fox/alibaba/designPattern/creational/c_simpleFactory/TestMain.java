package com.fox.alibaba.designPattern.creational.c_simpleFactory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-05 17:22
* @version 1.0
*/
public class TestMain {
    public static void main(String[] args) {
        Course javaCourse = CourseFactory.createCourse(CourseType.JAVA_COURSE);
        Course pythonCourse = CourseFactory.createCourse(CourseType.PYTHON_COURSE);
        javaCourse.record();
        pythonCourse.record();
    }

}
