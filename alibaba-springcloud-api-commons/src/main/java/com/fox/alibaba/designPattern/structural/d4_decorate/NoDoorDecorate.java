package com.fox.alibaba.designPattern.structural.d4_decorate;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 10:04
* @version 1.0
*/
public class NoDoorDecorate extends WulingDecorate {

	//调用父类的构造方法
	public NoDoorDecorate(WulingNewEngeryCar wulingNewEngeryCar) {
		super(wulingNewEngeryCar);
		// TODO Auto-generated constructor stub
	}
	@Override
	void run() {
		super.run();
		System.out.println("增加敞篷功能......");
	}

}
