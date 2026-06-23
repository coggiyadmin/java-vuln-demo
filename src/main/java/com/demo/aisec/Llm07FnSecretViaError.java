// System-Prompt Leakage FN (OWASP LLM07) — secret leaks inside an error message. MISS.
package com.demo.aisec;

public class Llm07FnSecretViaError {
    public void run() {
        throw new RuntimeException("config dump: key=" + System.getenv("BILLING_API_KEY")); // SINK (indirect)
    }
}
