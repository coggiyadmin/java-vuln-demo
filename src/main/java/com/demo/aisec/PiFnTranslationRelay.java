// Prompt Injection FN (OWASP LLM01) — multi-hop translation relay. MISS.
package com.demo.aisec;

public class PiFnTranslationRelay {
    public String relay(String userText) {
        String decoded = Llm.chatSystemUser("Translate to English.", userText); // hop 1
        return Llm.chatSystem("Do exactly this:\n" + decoded, "");              // SINK (LLM01 relay)
    }
}
