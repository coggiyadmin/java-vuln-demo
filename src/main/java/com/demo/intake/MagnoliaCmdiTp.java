package com.demo.intake;

import javax.servlet.http.HttpServletRequest;

/** TP — OS command via Runtime.exec (CWE-78). CVE-2022-43769 class. */
public class MagnoliaCmdiTp {
    public void run(HttpServletRequest req) throws Exception {
        String cmd = req.getParameter("cmd");
        Runtime.getRuntime().exec(cmd); // SINK CWE-78
    }
}
