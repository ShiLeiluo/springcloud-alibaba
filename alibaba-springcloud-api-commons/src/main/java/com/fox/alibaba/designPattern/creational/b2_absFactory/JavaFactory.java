package com.fox.alibaba.designPattern.creational.b2_absFactory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 10:31
* @version 1.0
*/
public class JavaFactory implements Factory {

	@Override
	public Note createNote() {
		// TODO Auto-generated method stub
		JavaNote javaNote = new JavaNote();
		return javaNote;
	}

	@Override
	public Video createVideo() {
		// TODO Auto-generated method stub
		JavaVideo javaVideo = new JavaVideo();
		return javaVideo;
	}
	
}
