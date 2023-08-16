package com.fox.alibaba.java8feature;

/**
* @author F1337248 ShiLeiluo
* @date 2023-08-09 15:38
* @version 1.0
*/
public class Lambda02 {
	interface DogService{
		Dog getDog(); //无参构造方法;
	}
    interface  DogService2{
        Dog getDog(int age,String name); //有参构造方法;
    }
	
	public static void main(String[] args) {
		/**
		 * 6. lambda表达式 - 构造函数引用
		 */
		DogService dogService = ()->new Dog();
		System.out.println(dogService.getDog());
		
		DogService2 dogService2 = (age, name)->new Dog(age, name);
		System.out.println(dogService2.getDog(3, "大黄"));
		
		DogService dogService_2 = Dog::new;
		System.out.println(dogService_2.getDog());
		
		DogService2 dogService2_2 = Dog::new;
		System.out.println(dogService2_2.getDog(2, "小黑"));
	}
}
