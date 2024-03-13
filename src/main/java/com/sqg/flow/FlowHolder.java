package com.sqg.flow;

import java.util.LinkedList;
import java.util.List;

public class FlowHolder {

    private List<Flow> flows;

    public FlowHolder() {

    }

    public FlowHolder(List<Flow> flows) {
        this.flows = flows;
    }

    public List<Flow> getFlows() {
        return flows;
    }
    public void setFlows(List<Flow> flows) {
        this.flows = flows;
    }

    public void addFlow(Flow flow) {
        if (this.flows == null){
            this.flows = new LinkedList<>();
        }
        this.flows.add(flow);
    }
}
