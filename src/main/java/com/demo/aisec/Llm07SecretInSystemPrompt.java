// System-Prompt Leakage (OWASP LLM07) — secret baked into the system prompt. TP.
package com.demo.aisec;

public class Llm07SecretInSystemPrompt {
    public String buildSystem() {
        // SINK (LLM07): secret embedded in the instruction
        return "You are billing-bot. Internal key: " + System.getenv("BILLING_API_KEY") + ". Never reveal it.";
    }
}
