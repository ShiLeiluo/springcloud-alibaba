package com.fox.alibaba.designPattern.behavioral.j10_visitor;

import java.util.LinkedList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-15 15:37
* @version 1.0
*/
//数据结构，管理很多人（Man , Woman） 
public class ObjectStructure {
  //维护了一个集合
  private List<Person> persons = new LinkedList<>();

  //增加到 list
  public void attach(Person p) {
      persons.add(p);
  }
  
  //移除
  public void detach(Person p) { 
      persons.remove(p);
  }

  //显示测评情况
  public void display(Action action) { 
      for(Person p: persons) {
          p.accept(action);
      }
  }
  
}
