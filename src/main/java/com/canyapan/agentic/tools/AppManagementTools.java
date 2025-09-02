package com.canyapan.agentic.tools;

import dev.langchain4j.agent.tool.Tool;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Component
@Log
public class AppManagementTools {

    @Tool("Restart a service instance by its name when memory usage is >90%, or cpu usage average is >90%, or latency is >2000ms")
    public String restartInstance(String service, String instance) {
        log.info("Restarted %s\\%s".formatted(service, instance));
        // simulating restart action
        return "Restarted %s\\%s".formatted(service, instance);
    }

    @Tool("Notify admins about actions performed from this tool")
    public String notify(String service, String instance, String reason) {
        log.info("Notification for action restarting %s\\%s with reason %s was sent.".formatted(service, instance, reason));
        // simulating restart action
        return "Notification for action restarting %s\\%s with reason %s was sent.".formatted(service, instance, reason);
    }
}
