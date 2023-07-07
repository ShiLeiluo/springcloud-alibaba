package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor1;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:49
* @version 1.0
*/
public class TestMain {
    public static void main(String[] args) {
        PassportForThirdAdapter adapter = new PassportForThirdAdapter();
        adapter.login("tom","123456");
        adapter.loginForQQ("sjooguwoersdfjhasjfsa");
        adapter.loginForWechat("slfsjoljsdo8234ssdfs");
    }

}
