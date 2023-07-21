package com.fox.alibaba.designPattern.behavioral.a0_interpret;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-21 08:53
* @version 1.0
*/
//数据源
public class TerminalExpression implements Expression {

  private String data;

  public TerminalExpression(String data){
      this.data = data;
  }

  //数据判断
  @Override
  public boolean interpret(String context) {
      //判断是否字符串中是否包含指定字符
      if(context.contains(data)){
          return true;
      }
      return false;
  }
}

