package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor1;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:48
* @version 1.0
*/
public class PassportService {

    /**
     * 注册方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg regist(String username,String password){
        return  new ResultMsg(200,"注册成功",new Member(username, password, username , username));
    }

    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public ResultMsg login(String username,String password){

    	
        return new ResultMsg(200,"登录成功",new Member(username, password, username , username));
    }

}

