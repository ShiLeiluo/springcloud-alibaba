package com.fox.alibaba.designPattern.behavioral.g7_state;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-14 15:49
* @version 1.0
*/
public class Client {
	public static void main(String[] args) {
      StatusContext context = new StatusContext(new YzfStatusOrderServiceImpl());
      context.handleOrderByState();
  }
}
