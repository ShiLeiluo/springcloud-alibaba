package com.fox.alibaba.designPattern.behavioral.f6_observer;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 18:44
* @version 1.0
* 个人股民
*/
public class PersonObserver implements ShareObserver {

	@Override
	public void response(int i) {
		// TODO Auto-generated method stub
		if(i>0) {
			System.out.println("游资: 涨了,快点投资投资......");
		}else {
			System.out.println("游资: 跌了,快点撤资撤资......");
		}
	}

}
