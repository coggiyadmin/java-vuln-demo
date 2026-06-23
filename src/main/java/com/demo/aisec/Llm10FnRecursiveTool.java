// Unbounded Consumption FN (OWASP LLM10) — recursive tool re-invokes the model. MISS.
package com.demo.aisec;

public class Llm10FnRecursiveTool {
    public String expand(String topic) {
        String sub = Llm.chatSystem("", "Sub-topics of " + topic);
        for (String line : sub.split("\n")) {
            if (!line.trim().isEmpty()) expand(line.trim()); // SINK (LLM10 recursive)
        }
        return sub;
    }
}
