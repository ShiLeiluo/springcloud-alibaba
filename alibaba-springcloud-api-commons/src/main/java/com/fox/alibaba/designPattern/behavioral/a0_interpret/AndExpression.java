package com.fox.alibaba.designPattern.behavioral.a0_interpret;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-21 08:53
* @version 1.0
*/
//解析器
public class AndExpression implements Expression {
  //数据源1
  private Expression expr1 = null;
  //数据源2
  private Expression expr2 = null;

  public AndExpression(Expression expr1, Expression expr2) {
      this.expr1 = expr1;
      this.expr2 = expr2;
  }

  //传进来的数据进行判断   都为true  就返回true 否则 返回false
  @Override
  public boolean interpret(String context) {
      return expr1.interpret(context) && expr2.interpret(context);
  }
}

