package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor1;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:48
* @version 1.0
*/
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String phone,String code);

}

