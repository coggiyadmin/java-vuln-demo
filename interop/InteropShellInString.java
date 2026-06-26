package com.demo.interop;

/** IL-1 polyglot — Java → shell DSL (CWE-78). */
public class InteropShellInString {
    public void run(String arg) throws Exception {
        // SINK (CWE-78): shell snippet built in Java string → /bin/sh -c.
        String cmd = "echo " + arg;
        Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", cmd});
    }
}
