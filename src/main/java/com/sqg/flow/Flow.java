package com.sqg.flow;


import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.NodeConfig;
import com.sqg.flow.enums.FlowStatusEnum;

import java.util.*;

public class Flow {
    List<Node> nodes;
    int status;

    public Flow() {
        status = FlowStatusEnum.INIT.getStatus();
    }

    public Flow createFlow(FlowConfig flowConfig){
        nodes = loadNodes(flowConfig.getNodes(),null);
        return this;
    }

    public Flow createFlow(FlowConfig flowConfig, Map<String,NodeFactory> nodeFactories){
        nodes = loadNodes(flowConfig.getNodes(),nodeFactories);
        return this;
    }

    private List<Node> loadNodes(List<NodeConfig> nodeConfigs, Map<String,NodeFactory> nodeFactories) {
        if (nodeFactories == null){
            nodeFactories = new HashMap<>();
        }
        LinkedList<Node> nodeLinkedList = new LinkedList<>();
        for (NodeConfig nodeConfig : nodeConfigs) {
            Node node = createNode(nodeConfig,nodeFactories);
            nodeLinkedList.add(node);
        }
        return nodeLinkedList;
    }

    public Node createNode(NodeConfig nodeConfig,Map<String,NodeFactory> nodeFactories) {
        NodeFactory nodeFactory = nodeFactories.get(nodeConfig.getType());
        if (nodeFactory != null){
            return nodeFactory.createNode(nodeConfig);
        }
        if (nodeConfig.getType().equals("startNode")){
            return new StartNode(nodeConfig.getName());
        }
        if ("bean".equals(nodeConfig.getLoadType())){

        }
        if ("ParallelNode".equals(nodeConfig.getType())){
            ParallelNode parallelNode = new ParallelNode(nodeConfig.getName());
            parallelNode.setNodes(loadNodes(nodeConfig.getParallelNodes(),nodeFactories));
            return parallelNode;
        }
        return new DefaultNode(nodeConfig.getName());
    }

    public synchronized void start() {
        status = FlowStatusEnum.START.getStatus();
        for (Node node : nodes) {
            node.execute(null);
        }
    }
}
