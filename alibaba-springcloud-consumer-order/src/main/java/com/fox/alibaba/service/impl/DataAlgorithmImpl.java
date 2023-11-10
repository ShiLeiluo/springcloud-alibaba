package com.fox.alibaba.service.impl;

import org.springframework.stereotype.Component;

import com.fox.alibaba.observermode.Observer;
import com.fox.alibaba.observermode.Subject;
import com.fox.alibaba.service.DataAlgorithm;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 10:14
* @version 1.0
*/
@Component
public class DataAlgorithmImpl extends Observer implements DataAlgorithm {

    public DataAlgorithmImpl(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }


    @Override
    public int algorithm() {
        subject.setState("0%");
        try {
            Thread.sleep(3000);
            subject.setState("10%");
            Thread.sleep(3000);
            subject.setState("20%");
            Thread.sleep(3000);
            subject.setState("30%");
            Thread.sleep(3000);
            subject.setState("40%");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String update() {
        return subject.getState();
    }
}
