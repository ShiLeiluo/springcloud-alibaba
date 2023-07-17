package com.fox.alibaba.designPattern.behavioral.j10_visitor;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-15 15:37
* @version 1.0
*/
public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(" 男人给的评价是该歌手待定 ..");
    }
    
    @Override
    public void getWomanResult(Woman woman) {
        System.out.println(" 女人给的评价是该歌手待定 ..");
    }
}


