package com.canyapan.agentic_sample.controllers;

import com.canyapan.agentic_sample.controllers.models.AppInput;
import com.canyapan.agentic_sample.controllers.models.AppOutput;
import com.canyapan.agentic_sample.controllers.models.InfoInput;
import com.canyapan.agentic_sample.controllers.models.InfoOutput;
import com.canyapan.agentic_sample.services.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/agent/")
@RequiredArgsConstructor
@Log
public class AgentController {

    private final AgentService service;

    @PostMapping("info")
    public InfoOutput info(@RequestBody InfoInput infoInput) {
        log.info("Received question: " + infoInput.getQuestion());
        final String answer = service.generateAnswer(infoInput.getQuestion());
        log.info("Returned answer: " + answer);
        return InfoOutput.builder()
                .answer(answer)
                .build();
    }

    @PostMapping("app")
    public AppOutput app(@RequestBody AppInput appInput) {
        log.info("Decide app: " + appInput);
        String action = service.performAppChecks(appInput);
        return AppOutput.builder()
                .action(action)
                .build();
    }

}
