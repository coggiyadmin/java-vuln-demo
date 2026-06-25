package com.demo;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * Combination #3 — LOOPTAINT × LOGINJ (CWE-117).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintLogInj {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) {
        String[] in = req.getParameterValues("user");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String user = items[0];
        Logger.getLogger("app").warning("login user=" + user); // CWE-117
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) {
        String user = "";
        for (String x : req.getParameterValues("user")) { user += x; }
        Logger.getLogger("app").warning("login user=" + user); // CWE-117
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) {
        for (String user : req.getParameterValues("user")) {
            Logger.getLogger("app").warning("login user=" + user); // CWE-117 per iteration
        }
    }

}
