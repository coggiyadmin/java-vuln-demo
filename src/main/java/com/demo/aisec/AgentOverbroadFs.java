// Excessive Agency (OWASP LLM06) — over-broad fs tool rooted at "/", no jail.
package com.demo.aisec;

import java.nio.file.Files;
import java.nio.file.Paths;

public class AgentOverbroadFs {
    private static final String FS_ROOT = "/"; // SINK (LLM06)
    public String readTool(String rel) throws Exception {
        return Files.readString(Paths.get(FS_ROOT, rel));
    }
}
