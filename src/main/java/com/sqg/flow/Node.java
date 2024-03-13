package com.sqg.flow;

import java.util.Map;

public abstract class Node {

    private String name;

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract void execute(Map<String,Object> context);


}
