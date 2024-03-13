package com.sqg.flow;

import com.sqg.flow.config.FlowConfig;
import com.sqg.flow.config.JsonConfigLoader;

public class FlowTestMain {

    public static void main(String[] args) {

        FlowConfig flowConfig = new JsonConfigLoader().load("ParallelFlow.json");
        Flow flow = new Flow().createFlow(flowConfig);
        flow.start();

    }
}
