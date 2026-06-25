package com.demo;

import freemarker.template.*;
import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;

/**
 * Combination #2 — PATHSENSITIVITY × SSTI (CWE-1336).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveSsti {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) throws Exception {
        String t = req.getParameter("t");
        if (t.equals("safe")) { /* guard covers only literal */ } else { new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); } // CWE-1336
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String t = req.getParameter("t");
        if (false) { t = "safe_literal"; } // dead branch
        new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); // CWE-1336
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String t = req.getParameter("t");
        if (t == null || t.isEmpty()) { return; }
        new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); // CWE-1336
    }

}
