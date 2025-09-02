package com.canyapan.agentic.agents;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface AppActionAgent {

    @UserMessage("""
        You are an AI agent to perform actions based on metrics from a service from memoryUsage, cpuUsageAverageLast1Min or latencyInMillisAverageLast1Min metrics from a service and its instance.
        This is not an interactive chat. Do not expect user input for further action.
        Service: {{service}}
        Instance: {{instance}}
        Memory Usage in Percentage in between 0 and 1: {{memoryUsage}}
        Cpu Usage Average For Last 1-min in between 0 and 1 : {{cpuUsageAverageLast1Min}}
        Average Latency in Millis for Last 1-min: {{latencyInMillisAverageLast1Min}}
        """)
    @Agent(outputName = "decideAction", description = "Decides action based on app metrics")
    String decideAction(
            @V("service") String service,
            @V("instance") String instance,
            @V("memoryUsage") Float memoryUsage,
            @V("cpuUsageAverageLast1Min") Float cpuUsageAverageLast1Min,
            @V("latencyInMillisAverageLast1Min") Long latencyInMillisAverageLast1Min);

}
