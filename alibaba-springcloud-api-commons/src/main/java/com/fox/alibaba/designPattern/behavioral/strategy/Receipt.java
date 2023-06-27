package com.fox.alibaba.designPattern.behavioral.strategy;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-26 15:49
* @version 1.0
*/
public class Receipt {
	private String type;
	private String message;
	
	public Receipt() {}
	public Receipt(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
