// SAFE mirror (OWASP LLM06) — fs tool exposes only constant, pre-vetted paths via a fixed key
// switch; user input never reaches the read path.
package com.demo.aisec;

import java.nio.file.Files;
import java.nio.file.Path;

public class SafeAgentOverbroadFs {
    public String readTool(String key) throws Exception {
        String p;
        switch (key) {
            case "readme": p = "/var/app/workspace/README.md"; break;
            case "config": p = "/var/app/workspace/config.json"; break;
            default: throw new SecurityException("not in allowlist");
        }
        return Files.readString(Path.of(p));
    }
}
