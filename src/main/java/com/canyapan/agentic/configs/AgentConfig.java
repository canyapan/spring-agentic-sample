package com.canyapan.agentic.configs;

import com.canyapan.agentic.agents.AppActionAgent;
import com.canyapan.agentic.agents.InfoAgent;
import com.canyapan.agentic.tools.AppManagementTools;
import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
public class AgentConfig {

    @Bean
    public ChatModel chatModel(
            @Value("${ollama.api}") String url,
            @Value("${ollama.model}") String model) {
        return OllamaChatModel.builder()
                .baseUrl(url)
                .modelName(model)
                .timeout(Duration.of(5, ChronoUnit.MINUTES))
                .build();
    }

    @Bean
    public InfoAgent infoAgent(ChatModel model) {
        return AgenticServices.agentBuilder(InfoAgent.class)
                .chatModel(model)
                .outputName("getAnswer")
                .build();
    }

    @Bean
    public AppActionAgent appActionAgent(ChatModel model, AppManagementTools appManagementTools) {
        return AgenticServices.agentBuilder(AppActionAgent.class)
                .chatModel(model)
                .outputName("decideAction")
                .tools(appManagementTools)
                .build();
    }

}
