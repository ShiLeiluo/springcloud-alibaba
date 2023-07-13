package com.fox.alibaba.designPattern.behavioral.c3_iterator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 15:08
* @version 1.0
*/

public class IteratorPatternDemo {
  
  public static void main(String[] args) {
     NameRepository namesRepository = new NameRepository();
     Iterator iter = namesRepository.getIterator();
     while (iter.hasNext()) {
         String name = (String)iter.next();
         System.out.println("Name : " + name);
		
	}
  }
}
