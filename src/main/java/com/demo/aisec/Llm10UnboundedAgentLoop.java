// Unbounded Consumption (OWASP LLM10) — agent loop with no iteration cap. TP.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.List;

public class Llm10UnboundedAgentLoop {
    public List<String> agent(String goal) {
        List<String> history = new ArrayList<>();
        history.add(goal);
        while (true) { // SINK (LLM10): no max-steps guard
            String msg = Llm.chatSystem("", String.join("\n", history));
            history.add(msg);
            if (msg.contains("DONE")) return history;
        }
    }
}
