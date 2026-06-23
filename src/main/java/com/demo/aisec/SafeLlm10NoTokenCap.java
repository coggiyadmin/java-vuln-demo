// SAFE mirror (OWASP LLM10) — input length capped before the call.
package com.demo.aisec;

public class SafeLlm10NoTokenCap {
    private static final int MAX_INPUT = 8000;
    public String summarize(String userText) {
        if (userText.length() > MAX_INPUT) throw new IllegalArgumentException("input too large");
        return Llm.chatSystem("", userText);
    }
}
