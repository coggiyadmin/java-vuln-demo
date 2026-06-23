// Prompt Injection FN (OWASP LLM01) — delimiter/role-fence break. MISS.
package com.demo.aisec;

public class PiFnDelimiterBreak {
    private static final String SYSTEM = "You are a translator. Translate text inside <data> tags.";
    public String translate(String userText) {
        String fenced = "<data>" + userText + "</data>"; // SINK (LLM01 delimiter break)
        return Llm.chatSystemUser(SYSTEM, fenced);
    }
}
