package com.sqg.flow.config;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class FlowConfig {

    private String flowName;
    private String startTime;

    private List<NodeConfig> nodes;
    private Map<String, Object> props;

    public FlowConfig() {
    }

    public List<NodeConfig> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeConfig> nodes) {
        this.nodes = nodes;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
