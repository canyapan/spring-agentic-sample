package com.canyapan.agentic.agents;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface InfoAgent {

    @UserMessage("You are an assistant. Answer the following question clearly and concisely.\nQuestion: {{question}}")
    @Agent(outputName = "answer", description = "Answers user questions")
    String getAnswer(@V("question") String question);

}
