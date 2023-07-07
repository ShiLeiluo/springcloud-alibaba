package com.fox.alibaba.designPattern.creational.b2_absFactory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 10:34
* @version 1.0
*/
public class TestMain {
	public static void main(String[] args) {
		JavaFactory javaFactory = new JavaFactory();
		PythonFactory pythonFactory = new PythonFactory();
		
		Note javaNote = javaFactory.createNote();
		Video javaVideo = javaFactory.createVideo();
		
		Note pythonNote = pythonFactory.createNote();
		Video pythonVideo = pythonFactory.createVideo();
		
		javaNote.show();
		javaVideo.play();
		
		pythonNote.show();
		pythonVideo.play();
	}
}
