package com.demo.aisec;

/** Excessive Agency (OWASP LLM06). */
public class AgentExcessiveAgency {
    public String shellTool(String command) throws Exception {
        Process p = Runtime.getRuntime().exec(new String[] { "sh", "-c", command });
        return new String(p.getInputStream().readAllBytes());
    }
}
