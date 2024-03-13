package com.sqg.flow;

import java.util.Map;

public class DefaultNode extends Node{

    public DefaultNode() {
    }

    public DefaultNode(String name) {
        super(name);
    }

    @Override
    public void execute(Map<String, Object> context) {
        System.out.println("DefaultNode execute,i am " + this.getName());
    }
}
