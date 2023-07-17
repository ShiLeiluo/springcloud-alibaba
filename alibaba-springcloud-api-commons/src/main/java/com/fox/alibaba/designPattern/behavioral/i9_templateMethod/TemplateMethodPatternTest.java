package com.fox.alibaba.designPattern.behavioral.i9_templateMethod;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-14 16:44
* @version 1.0
*/
public class TemplateMethodPatternTest {
    public static void main(String[] args) {
        AbstractCook crayfish = new Crayfish();
        crayfish.doCook();
        System.out.println("===========");
        FryRice fryRice = new FryRice();
        fryRice.doCook();

    }
}

