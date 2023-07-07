package com.fox.alibaba.designPattern.creational.d4_builder;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 10:49
* @version 1.0
*/
/**
 * 抽象Build的实现类--真正构建产品类
 * @author F1337248
 *
 */
public class ComputerBuilder extends Builder {
	
	private Computer computer = new Computer();

	@Override
	public void setBoard(String mBoard) {
		// TODO Auto-generated method stub
		computer.setmBoard(mBoard);
	}

	@Override
	public void setDisplay(String mDoisplay) {
		// TODO Auto-generated method stub
		computer.setmDisplay(mDoisplay);
	}

	@Override
	public void setOs(String mOS) {
		// TODO Auto-generated method stub
		computer.setmOS(mOS);
	}

	@Override
	public Computer create() {
		// TODO Auto-generated method stub
		return computer;
	}

}
