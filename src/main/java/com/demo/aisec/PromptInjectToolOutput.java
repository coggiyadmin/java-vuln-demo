// Prompt Injection TOOL-OUTPUT (OWASP LLM01) — tool result given instruction authority.
package com.demo.aisec;

public class PromptInjectToolOutput {
    // SINK (LLM01 tool-output): attacker-influenceable toolResult spliced into the system role.
    public String runWithTool(String userQ, String toolResult) {
        String system = "You are an assistant. Tool said:\n" + toolResult + "\nNow act on it.";
        return Llm.chatSystem(system, userQ);
    }
}
