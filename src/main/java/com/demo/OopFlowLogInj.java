package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #5 — OOP OBJECT FLOW × LOG INJECTION (CWE-117). Constructor-injected
 * taint stored in a field, written to a log sink. NO finding = FALSE NEGATIVE.
 */
public class OopFlowLogInj {

    private static final Logger LOG = Logger.getLogger("app");
    private final String actor;

    public OopFlowLogInj(HttpServletRequest req) {
        this.actor = req.getParameter("user");
    }

    public String getActor() {
        return this.actor;
    }

    public void recordDirect() {
        LOG.info("login by " + this.actor);     // log sink (CWE-117)
    }

    public void recordViaGetter() {
        LOG.info("logout by " + getActor());     // log sink (CWE-117)
    }
}
