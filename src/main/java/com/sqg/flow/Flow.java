package com.sqg.flow;


import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.NodeConfig;
import com.sqg.flow.enums.FlowStatusEnum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Flow {
    List<Node> nodes;
    int status;

    public Flow() {
        status = FlowStatusEnum.INIT.getStatus();
    }

    public Flow createFlow(FlowConfig flowConfig){
        nodes = loadNodes(flowConfig.getNodes());

        return this;
    }

    private List<Node> loadNodes(List<NodeConfig> nodeConfigs) {
        LinkedList<Node> nodeLinkedList = new LinkedList<>();
        for (NodeConfig nodeConfig : nodeConfigs) {
            Node node = createNode(nodeConfig);
            nodeLinkedList.add(node);
        }
        return nodeLinkedList;
    }

    public Node createNode(NodeConfig nodeConfig) {

        if (nodeConfig.getType().equals("startNode")){
            return new StartNode(nodeConfig.getName());
        }
        if ("bean".equals(nodeConfig.getLoadType())){

        }
        if ("ParallelNode".equals(nodeConfig.getType())){
            ParallelNode parallelNode = new ParallelNode(nodeConfig.getName());
            parallelNode.setNodes(loadNodes(nodeConfig.getParallelNodes()));
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
