package com.demo;

import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — ArgInjection; `--` terminates option parsing. Expect 0 findings. */
public class SafeArgInjection {
    public Process log(HttpServletRequest req) throws Exception {
        String branch = req.getParameter("branch");
        return new ProcessBuilder("git", "log", "--", branch).start(); // branch can't be a flag
    }
}
