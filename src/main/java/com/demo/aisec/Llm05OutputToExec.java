// Improper Output Handling (OWASP LLM05) — model output run as a shell command. TP.
package com.demo.aisec;

public class Llm05OutputToExec {
    public Process runGenerated(String modelOutput) throws Exception {
        // SINK (LLM05): model output executed by the shell
        return Runtime.getRuntime().exec(new String[] {"sh", "-c", modelOutput});
    }
}
