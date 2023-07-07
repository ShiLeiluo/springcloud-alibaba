package com.fox.alibaba.designPattern.structural.c3_composite;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:14
* @version 1.0
*/
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public void operation(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }
}

