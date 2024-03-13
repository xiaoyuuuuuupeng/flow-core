package com.sqg.flow;

import java.util.Map;

public class StartNode extends Node{

    public StartNode(String name) {
        super(name);
    }
    @Override
    public void execute(Map<String, Object> context) {
        System.out.println("startNode executed...");
    }
}
