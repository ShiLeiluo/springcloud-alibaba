package com.fox.alibaba.java8feature;

/**
* @author F1337248 ShiLeiluo
* @date 2023-08-09 08:34
* @version 1.0
* lambda 表达式, java 8 新特性
* 本质: 匿名函数
*/
public class Lambda01 {
	public static void main(String[] args) {
		// 1. 匿名内部类, 实现接口
		Call call = new Call() {

			@Override
			public int add(int a, int b) {
				// TODO Auto-generated method stub
				return a + b + 1;
			}
			
		};
		int add = call.add(0, 0);
		System.out.println("call: "+ add);
		System.out.println("----------------------");
		
		/**
		 * 2. lambda表达式
		 * 只适合接口中定义一个方法
		 * Call call=()->{};
		 * ()里面是参数, ->是lambda运算符, {}里面是方法体
		 */
		Call call2 = (int a, int b)->{
			return a+b+2;
		};
		int add2 = call2.add(0, 0);
		System.out.println("call2: "+add2);
		System.out.println("----------------------");
		
		/**
		 * 3. lambda表达式, 精简语法
		 * 
		 * 1. 参数类型可以省略 (int a, int b) => (a, b)
		 * 2. 假如只有一条语句, {}可以省略, 无返回值可以省略{}, 需要return不可以省略, Call call = (a, b)->System.out.println(a + b);
		 * 3. 如果唯一的一条语句是return语句, 省略{}同时也要省略return, Call call = (a, b)->a+b+1;
		 * 
		 */
		Call call3 = (int a, int b)->{return a+b+3;};
		int add3 = call3.add(0, 0);
		System.out.println("call3: " + add3);
		System.out.println("----------------------");
		
		/**
		 * 4. lambda非静态方法引用
		 * 
		 */
		Lambda01 lambda01A = new Lambda01();
		Call call4 = lambda01A::testA;
		System.out.println("call4: "+call4.add(0,0));
		System.out.println("----------------------");
		/**
		 * 5. lambda静态方法引用
		 * 
		 */
		Call call5 = Lambda01::testB;
		System.out.println("call5: "+call5.add(0,0));
		System.out.println("----------------------");
	}
	//******************************************************************
	private int testA(int a, int b) {
		System.out.println("**执行testA()**a-->"+a+", b-->"+b);
		return a+b+4;
	}
	private static int testB(int a, int b) {
		System.out.println("**执行testB()**a-->"+a+", b-->"+b);
		return a+b+5;
	}
	
	
	/**
	 * 定义接口
	 */
	interface Call{
		//定义接口中的方法
		int add(int a, int b);
	}
}
