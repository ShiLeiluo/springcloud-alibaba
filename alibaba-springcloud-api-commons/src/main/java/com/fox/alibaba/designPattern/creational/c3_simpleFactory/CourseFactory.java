package com.fox.alibaba.designPattern.creational.c3_simpleFactory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-05 17:17
* @version 1.0
*/
public class CourseFactory {
    public static Course createCourse(CourseType courseType){
        switch(courseType){
            case JAVA_COURSE: return new JavaCourse();
            case PYTHON_COURSE: return new PythonCourse();
            default: return null;
        }
    }
}

