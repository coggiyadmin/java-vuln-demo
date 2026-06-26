package com.demo.intake;

import javax.servlet.http.HttpServletRequest;

/** TP — Runtime.exec with user command string (CWE-78 intake pattern). CVE-2021-1498 class. */
public class RuntimeExecCmdiTp {
    public void run(HttpServletRequest req) throws Exception {
        String cmd = req.getParameter("cmd");
        Runtime.getRuntime().exec(cmd); // SINK CWE-78
    }
}
