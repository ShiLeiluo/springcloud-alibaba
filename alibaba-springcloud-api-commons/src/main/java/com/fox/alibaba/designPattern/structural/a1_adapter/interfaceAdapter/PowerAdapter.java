package com.fox.alibaba.designPattern.structural.a1_adapter.interfaceAdapter;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 15:57
* @version 1.0
*/
public class PowerAdapter implements DC {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    public int output5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }

    public int output12V() {
        return 0;
    }

    public int output24V() {
        return 0;
    }

    public int output36V() {
        return 0;
    }
}

