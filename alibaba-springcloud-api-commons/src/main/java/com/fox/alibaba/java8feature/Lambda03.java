package com.fox.alibaba.java8feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
* @author F1337248 ShiLeiluo
* @date 2023-08-11 11:25
* @version 1.0
*/
public class Lambda03 {
	public static void main(String[] args) {
		List<Dog> arrayList = new ArrayList<>();
		
		arrayList.add(new Dog(1, "aa"));
		arrayList.add(new Dog(3, "bb"));
		arrayList.add(new Dog(4, "cc"));
		arrayList.add(new Dog(2, "dd"));
		arrayList.add(new Dog(5, "ee"));
		
		System.out.println("未排序的数据: "+arrayList.toString());
        arrayList.forEach(new Consumer<Dog>() {
            @Override
            public void accept(Dog dog) {
                System.out.println(dog);
            }
        });
		System.out.println("----------------");
		System.out.println("排序 Collections");
		Collections.sort(arrayList, new Comparator<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				// TODO Auto-generated method stub
				return o2.getAge() - o1.getAge();
			}
			
		});
		System.out.println(arrayList.toString());
		System.out.println("----------------");
		System.out.println("排序 lambda");
		arrayList.sort((a, b)->{return a.getAge()-b.getAge();});
		arrayList.sort((a, b)->a.getAge()-b.getAge());
		System.out.println(arrayList.toString());
		
        System.out.println("遍历集合-------->");
		arrayList.forEach(System.out::println);
//		(参数列表)->{方法体}
		arrayList.forEach((a)->System.out.println(a));
		System.out.println("Stream-------->");
		List<Dog> stream = arrayList.stream().filter(dog->{
        	return dog.getAge() > 1;
        })
        .map(dog->{
        	if ("dd".equals(dog.getName())) {
        		dog.setName("ddd");
			}
        	return dog;
        })
//        .collect(Collectors.toCollection(ArrayList<Dog>::new))
        .collect(Collectors.toList());
        System.out.println(stream.toString());
        
        
	}
}
