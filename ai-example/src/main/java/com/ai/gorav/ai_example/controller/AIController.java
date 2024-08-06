package com.ai.gorav.ai_example.controller;

import lombok.AllArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
@AllArgsConstructor
public class AIController {

    private OllamaChatModel chatClient;
    private static final String PROMPT = "What is Java language";

    @GetMapping("/prompt")
    public Flux<String> promptResponse(@RequestParam("query") String query){

        return chatClient.stream(query);
    }
}
