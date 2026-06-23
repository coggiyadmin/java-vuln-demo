// SAFE mirror (OWASP LLM05) — model output parsed as an integer, never executed.
package com.demo.aisec;

public class SafeLlm05OutputToExec {
    public int runGenerated(String modelOutput) {
        return Integer.parseInt(modelOutput.trim());
    }
}
