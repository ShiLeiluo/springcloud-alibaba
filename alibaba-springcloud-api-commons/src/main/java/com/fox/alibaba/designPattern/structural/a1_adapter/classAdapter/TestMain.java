package com.fox.alibaba.designPattern.structural.a1_adapter.classAdapter;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 15:07
* @version 1.0
*/
public class TestMain {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter();
        adapter.output5V();
    }
}
