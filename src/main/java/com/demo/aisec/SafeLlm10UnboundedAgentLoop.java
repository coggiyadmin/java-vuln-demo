// SAFE mirror (OWASP LLM10) — bounded by a hard max-steps budget.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.List;

public class SafeLlm10UnboundedAgentLoop {
    private static final int MAX_STEPS = 8;
    public List<String> agent(String goal) {
        List<String> history = new ArrayList<>();
        history.add(goal);
        for (int i = 0; i < MAX_STEPS; i++) {
            String msg = Llm.chatSystem("", String.join("\n", history));
            history.add(msg);
            if (msg.contains("DONE")) break;
        }
        return history;
    }
}
