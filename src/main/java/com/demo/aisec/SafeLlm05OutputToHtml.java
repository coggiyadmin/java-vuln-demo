// SAFE mirror (OWASP LLM05) — model output HTML-escaped before rendering.
package com.demo.aisec;

public class SafeLlm05OutputToHtml {
    public String renderAnswer(String answer) {
        String safe = answer.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
        return "<div>" + safe + "</div>";
    }
}
