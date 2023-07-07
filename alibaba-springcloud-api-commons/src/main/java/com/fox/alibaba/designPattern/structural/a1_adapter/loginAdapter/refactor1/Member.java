package com.fox.alibaba.designPattern.structural.a1_adapter.loginAdapter.refactor1;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-06 16:48
* @version 1.0
*/
public class Member {

    private String username;
    private String password;
    private String mid;
    private String info;

    public Member(String username, String password, String mid, String info) {
		super();
		this.username = username;
		this.password = password;
		this.mid = mid;
		this.info = info;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

