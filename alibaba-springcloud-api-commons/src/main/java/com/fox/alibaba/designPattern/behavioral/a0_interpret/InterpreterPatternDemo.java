package com.fox.alibaba.designPattern.behavioral.a0_interpret;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-21 08:54
* @version 1.0
*/
public class InterpreterPatternDemo {

    // 数据必须包含  Robert 或者 John
    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    // 数据必须包含  Married 和 Julie
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression(); //or
        System.out.println( isMale.interpret("John"));
        
        Expression isMarriedWoman = getMarriedWomanExpression(); //and
        System.out.println(isMarriedWoman.interpret("Married Julie"));
    }
}
