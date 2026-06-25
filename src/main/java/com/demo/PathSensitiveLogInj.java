package com.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Combination #2 — PATHSENSITIVITY × LOGINJ (CWE-117).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveLogInj {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) {
        String user = req.getParameter("user");
        if (user.equals("safe")) { /* guard covers only literal */ } else { Logger.getLogger("app").warning("login user=" + user); } // CWE-117
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) {
        String user = req.getParameter("user");
        if (false) { user = "safe_literal"; } // dead branch
        Logger.getLogger("app").warning("login user=" + user); // CWE-117
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) {
        String user = req.getParameter("user");
        if (user == null || user.isEmpty()) { return; }
        Logger.getLogger("app").warning("login user=" + user); // CWE-117
    }

}
