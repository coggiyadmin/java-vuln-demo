package com.demo;

import javax.servlet.http.HttpServletRequest;

/** CWE-88 — Argument Injection. User input passed as a CLI arg without `--`. NO finding = FN. */
public class ArgInjection {
    public Process log(HttpServletRequest req) throws Exception {
        String branch = req.getParameter("branch");   // SOURCE
        // branch like "--output=/etc/cron.d/x" is parsed as an option → CWE-88
        return new ProcessBuilder("git", "log", branch).start();
    }
}
