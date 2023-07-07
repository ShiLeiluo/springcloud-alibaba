package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor2;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:50
* @version 1.0
*/
public abstract class AbstraceAdapter extends PassportService implements ILonginAdapter {
    protected ResultMsg loginForRegist(String username, String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        super.regist(username,password);
        return super.login(username,password);
    }
}

