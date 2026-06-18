package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — OopFlowLogInj; CR/LF stripped before logging. Expect 0 findings. */
public class SafeOopFlowLogInj {

    private static final Logger LOG = Logger.getLogger("app");
    private final String actor;

    public SafeOopFlowLogInj(HttpServletRequest req) {
        this.actor = req.getParameter("user");
    }

    private String clean() {
        return this.actor.replaceAll("[\\r\\n]", "");   // strip CRLF
    }

    public void recordDirect() {
        LOG.info("login by " + clean());
    }
}
