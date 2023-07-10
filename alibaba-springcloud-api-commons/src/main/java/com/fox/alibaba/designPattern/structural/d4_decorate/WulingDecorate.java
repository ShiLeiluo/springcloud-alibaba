package com.fox.alibaba.designPattern.structural.d4_decorate;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 10:00
* @version 1.0
*/
public abstract class WulingDecorate extends WulingNewEngeryCar {
	//私有对象
	private WulingNewEngeryCar wulingNewEngeryCar;
	//公共构造函数
	public WulingDecorate(WulingNewEngeryCar wulingNewEngeryCar) {
		this.wulingNewEngeryCar = wulingNewEngeryCar;
	}

	@Override
	void run() {
		// TODO Auto-generated method stub
		wulingNewEngeryCar.run();
	}

}
