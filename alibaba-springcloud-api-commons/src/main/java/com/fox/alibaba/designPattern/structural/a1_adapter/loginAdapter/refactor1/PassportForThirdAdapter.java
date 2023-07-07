package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor1;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:49
* @version 1.0
*/
public class PassportForThirdAdapter extends PassportService implements IPassportForThird {

    public ResultMsg loginForQQ(String openId) {
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForWechat(String openId) {
        return loginForRegist(openId,null);
    }

    public ResultMsg loginForToken(String token) {
        return loginForRegist(token,null);
    }

    public ResultMsg loginForTelphone(String phone, String code) {
        return loginForRegist(phone,null);
    }

    private ResultMsg loginForRegist(String username,String password){
        if(null == password){
            password = "THIRD_EMPTY";
        }
        ResultMsg msg = super.regist(username,password);
        System.out.println(msg.getMsg()+ " " + ((Member) msg.getData()).getUsername()+ " " + ((Member) msg.getData()).getPassword());
        return super.login(username,password);
    }
}
