package com.fox.alibaba.designPattern.behavioral.f6_observer;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 18:46
* @version 1.0
*/
public class CompanyObserver implements ShareObserver {

	@Override
	public void response(int i) {
		// TODO Auto-generated method stub
		if(i>0) {
			System.out.println("游资: 涨了,再拉点投资吧......");
		}else {
			System.out.println("游资: 跌了,稳一点,先不动......");
		}
	}

}
