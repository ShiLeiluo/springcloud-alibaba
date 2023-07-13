package com.fox.alibaba.designPattern.behavioral.a1_chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2023-05-06 11:16
* @version 1.0
*/
public class FatherFilterChain {
	//储存http和msg的Filter
	List<FatherFilter> list = new ArrayList<>();
	//添加Filter
	public void add(FatherFilter fatherFilter) {
		list.add(fatherFilter);
		
	}
	//定义执行过滤的方法
	public void doFilter(String msg) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).doFilter(msg);
		}
	}
	
}
