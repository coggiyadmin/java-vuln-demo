package com.demo;

import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #2 — PATH-SENSITIVITY × SSRF (CWE-918). Each method is a REAL SSRF on at
 * least one path. A method with NO finding is a FALSE NEGATIVE.
 */
public class PathSensitiveSsrf {

    // 2a. NEGATED GUARD — tainted URL fetched in the failure branch
    public void neg(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url");
        if (!url.startsWith("https://api.internal/")) {
            new URL(url).openStream();   // fetched anyway -> CWE-918
        }
    }

    // 2b. ONE-BRANCH CONSTRAINT — else path leaves the URL unchecked
    public void oneBranch(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url");
        if (req.getParameter("strict") != null) {
            url = "https://api.internal/" + url.substring(url.lastIndexOf('/') + 1);
        }
        new URL(url).openStream();       // else path tainted -> CWE-918
    }

    // 2c. EARLY-RETURN GUARD that does not cover the sink path
    public void early(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url");
        if (url.isEmpty()) {
            return;
        }
        new URL(url).openStream();       // CWE-918
    }
}
