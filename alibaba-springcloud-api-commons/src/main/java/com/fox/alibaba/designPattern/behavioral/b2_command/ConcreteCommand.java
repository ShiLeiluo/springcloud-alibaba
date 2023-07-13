package com.fox.alibaba.designPattern.behavioral.b2_command;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-10 15:58
* @version 1.0
*/
public class ConcreteCommand implements Command{
    /**
     * 持有相应的接收者对象
     */
    private Receiver receiver = null;
 
    /**
     * 构造方法，传入相应的接收者对象
     *
     * @param receiver 相应的接收者对象
     */
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
 
    /**
     * 执行命令
     */
    @Override
    public void execute() {
        // 通常会转调接收者对象的相应方法，让接收者来真正执行功能
        receiver.action();
    }
 
}