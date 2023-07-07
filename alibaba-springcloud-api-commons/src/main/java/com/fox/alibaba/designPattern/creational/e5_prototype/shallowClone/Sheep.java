package com.fox.alibaba.designPattern.creational.e5_prototype.shallowClone;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 11:11
* @version 1.0
*/
//具体原型类
public class Sheep implements Cloneable {
	private String name;
	private int age;
	private String color;
	private String address = "蒙古羊";
	public Sheep friend; //是对象, 克隆是会如何处理
	public Sheep(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	@Override
	public String toString() {
		return "Sheep [name=" + name + ", age=" + age + ", color=" + color + ", address=" + address + "]";
	}
	//克隆该实例
	//重写clone方法，或者用默认的clone方法也行，只不过调用时候需要抛异常
	@Override
	protected Object clone()  {
		Sheep sheep = null;
		try {
			sheep = (Sheep)super.clone();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sheep;
	}
	
	//--访问类
		//可以看出都是克隆的原型，调用原型类的clone来复制对象
		public static void main(String[] args)  {
			System.out.println("原型模式完成对象的创建");
		
			Sheep sheep = new Sheep("tom", 1, "白色");

			sheep.friend = new Sheep("jack", 2, "黑色");

			Sheep sheep2 = (Sheep)sheep.clone(); //克隆
			Sheep sheep3 = (Sheep)sheep.clone(); //克隆
			Sheep sheep4 = (Sheep)sheep.clone(); //克隆
			Sheep sheep5 = (Sheep)sheep.clone(); //克隆
			
			System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
			System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
			System.out.println("sheep4 =" + sheep4 + "sheep4.friend=" + sheep4.friend.hashCode());
			System.out.println("sheep5 =" + sheep5 + "sheep5.friend=" + sheep5.friend.hashCode());
		}
}




