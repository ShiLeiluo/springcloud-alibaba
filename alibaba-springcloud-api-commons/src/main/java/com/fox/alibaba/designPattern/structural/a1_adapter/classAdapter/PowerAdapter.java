package com.fox.alibaba.designPattern.structural.a1_adapter.classAdapter;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 15:06
* @version 1.0
*/
// 创建Adapter角色电源适配器PowerAdapter类：
public class PowerAdapter extends AC220 implements DC5 {

	@Override
    public int output5V() {
        int adapterInput = super.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用Adapter输入AC" + adapterInput + "V,输出DC" + adapterOutput + "V");
        return adapterOutput;
    }
}

