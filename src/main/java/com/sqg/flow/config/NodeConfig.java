package com.sqg.flow.config;

import java.util.List;
import java.util.Map;

public class NodeConfig {
    private String name;
    private String type;
    private String loadType;
    private Map<String,Object> props;

    private List<NodeConfig> parallelNodes;

    public NodeConfig() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }

    public List<NodeConfig> getParallelNodes() {
        return parallelNodes;
    }

    public void setParallelNodes(List<NodeConfig> parallelNodes) {
        this.parallelNodes = parallelNodes;
    }
}
