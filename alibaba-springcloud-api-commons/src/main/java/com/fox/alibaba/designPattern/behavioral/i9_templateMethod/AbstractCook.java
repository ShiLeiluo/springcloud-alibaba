package com.fox.alibaba.designPattern.behavioral.i9_templateMethod;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-14 16:43
* @version 1.0
*/
public abstract class AbstractCook {

    public final void doCook(){
        openFire();
        cooking();
        closedFire();
    }

    protected abstract void cooking();

    protected void openFire() {
        System.out.println("点火，开始做菜了");
    }
    protected void closedFire() {
        System.out.println("关火，菜出锅了");
    }
}

