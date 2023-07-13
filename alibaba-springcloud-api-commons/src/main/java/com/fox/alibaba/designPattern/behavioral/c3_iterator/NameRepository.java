package com.fox.alibaba.designPattern.behavioral.c3_iterator;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-11 15:07
* @version 1.0
*/

public class NameRepository implements Container {
  public String[] names = {"Robert" , "John" ,"Julie" , "Lora"};

  @Override
  public Iterator getIterator() {
     return new NameIterator();
  }

  private class NameIterator implements Iterator {

     int index;

     @Override
     public boolean hasNext() {
        if(index < names.length){
           return true;
        }
        return false;
     }

     @Override
     public Object next() {
        if(this.hasNext()){
           return names[index++];
        }
        return null;
     }     
  }
}
