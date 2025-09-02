package com.canyapan.agentic_sample.services;

import com.canyapan.agentic_sample.agents.AppActionAgent;
import com.canyapan.agentic_sample.agents.InfoAgent;
import com.canyapan.agentic_sample.controllers.models.AppInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log
public class AgentService {

    private final InfoAgent infoAgent;
    private final AppActionAgent appActionAgent;

    public String generateAnswer(String question) {
        return infoAgent.getAnswer(question);
    }

    public String performAppChecks(AppInput appInput) {
        return appActionAgent.decideAction(appInput.getService(), appInput.getInstance(),
                appInput.getMemoryUsage(), appInput.getCpuUsageAverageLast1Min(), appInput.getLatencyInMillisAverageLast1Min());
    }

}
