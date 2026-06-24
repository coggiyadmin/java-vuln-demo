// TP (CWE-78) — genuine OS command injection via Runtime.exec on user input.
package com.demo.libapi;

public class OsCommandExec {
    public Process run(String userCmd) throws Exception {
        return Runtime.getRuntime().exec(userCmd); // SINK (CWE-78)
    }
}
