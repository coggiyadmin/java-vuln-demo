// Improper Output Handling FN (OWASP LLM05) — deferred exec; output written then run later. MISS.
package com.demo.aisec;

import java.nio.file.Files;
import java.nio.file.Path;

public class Llm05FnOutputToFileExec {
    private static final Path SCRIPT = Path.of("/var/app/plugins/generated.sh");
    public void stage(String code) throws Exception { Files.writeString(SCRIPT, code); } // SOURCE
    public Process activate() throws Exception {                                          // SINK (deferred)
        return Runtime.getRuntime().exec(new String[] {"sh", SCRIPT.toString()});
    }
}
