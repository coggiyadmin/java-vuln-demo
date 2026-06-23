// SAFE mirror (OWASP LLM07) — no secret in the prompt; key stays server-side.
package com.demo.aisec;

public class SafeLlm07SecretInSystemPrompt {
    public String buildSystem() {
        return "You are billing-bot. Use the authorized billing tool for balances.";
    }
}
