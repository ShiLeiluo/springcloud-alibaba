package com.fox.alibaba.designPattern.structural.c3_composite;

import java.util.ArrayList;
import java.util.List;

/**
* @author F1337248 ShiLeiluo
* @date 2023-07-07 15:15
* @version 1.0
*/
public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public Component getChild(int index) {
        return children.get(index);
    }

    public void operation(int depth) {
        super.operation(depth);
        
        for (Component component : children) {
            component.operation(depth + 1);
        }
    }
}
