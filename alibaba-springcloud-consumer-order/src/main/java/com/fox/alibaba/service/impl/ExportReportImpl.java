package com.fox.alibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fox.alibaba.observermode.Observer;
import com.fox.alibaba.observermode.Subject;
import com.fox.alibaba.service.DataAlgorithm;
import com.fox.alibaba.service.ExportReport;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 10:11
* @version 1.0
*/
@Component
public class ExportReportImpl extends Observer implements ExportReport {

    @Autowired
    private DataAlgorithm a;

    public ExportReportImpl(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public String export() {
        subject.setState("b类开始。。。。。");
        int a1 = a.algorithm();
        try {
            Thread.sleep(3000);
            subject.setState("52%");
            Thread.sleep(3000);
            subject.setState("55%");
            Thread.sleep(3000);
            subject.setState("58%");
            Thread.sleep(3000);
            subject.setState("60%");
            Thread.sleep(3000);
            subject.setState("65%");
            Thread.sleep(3000);
            subject.setState("70%");
            Thread.sleep(3000);
            subject.setState("75%");
            Thread.sleep(3000);
            subject.setState("80%");
            Thread.sleep(3000);
            subject.setState("85%");
            Thread.sleep(3000);
            subject.setState("90%");
            Thread.sleep(3000);
            subject.setState("100%");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (a1==0) {
            return "结果为 0";
        }
        return "结果为 1";
    }

    @Override
    public String update() {
        return  subject.getState();
    }
}
