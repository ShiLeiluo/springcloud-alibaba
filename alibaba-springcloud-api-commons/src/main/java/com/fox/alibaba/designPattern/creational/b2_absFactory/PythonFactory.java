package com.fox.alibaba.designPattern.creational.b2_absFactory;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 10:33
* @version 1.0
*/
public class PythonFactory implements Factory {

	@Override
	public Note createNote() {
		// TODO Auto-generated method stub
		PythonNote pythonNote = new PythonNote();
		return pythonNote;
	}

	@Override
	public Video createVideo() {
		// TODO Auto-generated method stub
		PythonVideo pythonVideo = new PythonVideo();
		return pythonVideo;
	}

}
