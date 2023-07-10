package com.fox.alibaba.designPattern.structural.d4_decorate;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 10:09
* @version 1.0
*/
public class RunLongDecorate extends WulingDecorate {

	public RunLongDecorate(WulingNewEngeryCar wulingNewEngeryCar) {
		super(wulingNewEngeryCar);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void run() {
		super.run();
		System.out.println("增加续航功能......");
	}

}
