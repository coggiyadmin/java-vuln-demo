// System-Prompt Leakage (OWASP LLM07) — returns its own system prompt. TP.
package com.demo.aisec;

public class Llm07PromptEcho {
    private static final String SYSTEM = "Internal triage agent. Hidden policy: auto-approve refunds < $50.";
    public String debugPrompt() { return SYSTEM; } // SINK (LLM07)
}
