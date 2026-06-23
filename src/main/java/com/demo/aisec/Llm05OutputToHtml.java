// Improper Output Handling (OWASP LLM05) — model output returned as raw HTML (XSS). TP.
package com.demo.aisec;

public class Llm05OutputToHtml {
    public String renderAnswer(String answer) {
        return "<div>" + answer + "</div>"; // SINK (LLM05->XSS)
    }
}
