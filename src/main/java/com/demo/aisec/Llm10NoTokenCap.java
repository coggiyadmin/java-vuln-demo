// Unbounded Consumption (OWASP LLM10) — no length/token cap on a user-driven completion. TP.
package com.demo.aisec;

public class Llm10NoTokenCap {
    public String summarize(String userText) { return Llm.chatSystem("", userText); } // SINK (LLM10)
}
