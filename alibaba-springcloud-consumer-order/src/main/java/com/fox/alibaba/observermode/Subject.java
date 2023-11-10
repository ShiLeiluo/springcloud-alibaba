package com.fox.alibaba.observermode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 10:13
* @version 1.0
*/
@Component
public class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
