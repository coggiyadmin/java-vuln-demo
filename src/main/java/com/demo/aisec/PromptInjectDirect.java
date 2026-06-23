package com.demo.aisec;

/** Prompt Injection DIRECT (OWASP LLM01). */
public class PromptInjectDirect {
    public String answer(String userQuestion) {
        String system = "You are a support bot.\n" + userQuestion;
        return "llm:" + system;
    }
}
