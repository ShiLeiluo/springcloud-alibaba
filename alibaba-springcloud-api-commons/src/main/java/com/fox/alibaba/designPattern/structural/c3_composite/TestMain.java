package com.fox.alibaba.designPattern.structural.c3_composite;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:15
* @version 1.0
*/
public class TestMain {
	public static void main(String[] args) {
	    Component leaf1 = new Leaf("leaf1");
	    Component leaf2 = new Leaf("leaf2");
	    Component leaf3 = new Leaf("leaf3");
	    Component leaf4 = new Leaf("leaf4");
	    Component leaf5 = new Leaf("leaf5");

	    Component composite1 = new Composite("composite1");
	    composite1.add(leaf1);
	    composite1.add(leaf2);

	    Component composite2 = new Composite("composite2");
	    composite2.add(leaf3);
	    composite2.add(leaf4);

	    Component composite3 = new Composite("composite3");
	    composite3.add(composite1);
	    composite3.add(composite2);
	    composite3.add(leaf5);

	    composite3.operation(0);
	}

}
