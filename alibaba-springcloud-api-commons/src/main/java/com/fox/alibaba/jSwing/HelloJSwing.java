package com.fox.alibaba.jSwing;

import javax.swing.JFrame;

/**
* @author F1337248 ShiLeiluo
* @date 2023-11-24 09:49
* @version 1.0
*/
public class HelloJSwing {
	public static void main(String[] args) {
		//定义一个窗体对象f，窗体名称为"一个简单窗口"    
		JFrame f = new JFrame("一个简单窗口");
		/*设置窗体左上角与显示屏左上角的坐标，
		离显示屏上边缘300像素，离显示屏左边缘300像素   */
		f.setLocation(300, 300);
		//f.setLocationRelativeTo(null);本语句实现窗口居屏幕中央
		f.setSize(300,200);
		//设置窗体的大小为300*200像素大小
		f.setResizable(false);
		//设置窗体是否可以调整大小，参数为布尔值
		//设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
		f.setVisible( true);
		//用户单击窗口的关闭按钮时程序执行的操作
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
