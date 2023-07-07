package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor2;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:49
* @version 1.0
*/
public class TestMain {
    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();
        adapter.loginForQQ("sdfasdfasfasfas");
    }


}
