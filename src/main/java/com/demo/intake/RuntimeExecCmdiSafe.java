package com.demo.intake;

import javax.servlet.http.HttpServletRequest;

/** Safe mirror — allowlisted report labels only. */
public class RuntimeExecCmdiSafe {
    public void run(HttpServletRequest req) throws Exception {
        String label = req.getParameter("label");
        String script;
        switch (label) {
            case "daily" -> script = "daily";
            case "weekly" -> script = "weekly";
            default -> throw new SecurityException("forbidden");
        }
        new ProcessBuilder("/opt/app/bin/report.sh", script).start();
    }
}
