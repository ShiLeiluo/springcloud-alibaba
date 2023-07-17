package com.fox.alibaba.designPattern.behavioral.g7_state;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-14 15:42
* @version 1.0
*/
public class StatusContext {
    private IOrderState iOrderState;
 
    public StatusContext(IOrderState _iOrderState){
        this.iOrderState = _iOrderState;
    }
 
    public void handleOrderByState(){
        iOrderState.handleOrderByState();
    }
}
