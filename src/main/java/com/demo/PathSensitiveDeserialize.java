package com.demo;

import java.io.*;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #2 — PATHSENSITIVITY × DESERIALIZE (CWE-502).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class PathSensitiveDeserialize {

    // 2a. NEGATED GUARD
    public void neg(HttpServletRequest req) throws Exception {
        String s = req.getParameter("s");
        if (s.equals("safe")) { /* guard covers only literal */ } else { new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); } // CWE-502
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves value unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String s = req.getParameter("s");
        if (false) { s = "safe_literal"; } // dead branch
        new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); // CWE-502
    }

    // 2c. EARLY-RETURN GUARD that does NOT cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String s = req.getParameter("s");
        if (s == null || s.isEmpty()) { return; }
        new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); // CWE-502
    }

}
