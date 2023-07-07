package com.fox.alibaba.designPattern.structural.a1_adapter.interfaceAdapter;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 15:58
* @version 1.0
*/
public class TestMain {
    public static void main(String[] args) {
        DC adapter = new PowerAdapter(new AC220());
        adapter.output5V();
    }
}
