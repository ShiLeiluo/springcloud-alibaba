package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor2;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:50
* @version 1.0
*/
public class LoginForQQAdapter extends AbstraceAdapter{
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        if(!support(adapter)){return null;}
        //accesseToken
        //time
        return super.loginForRegist(id,null);

    }
}

