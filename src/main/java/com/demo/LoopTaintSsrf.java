package com.demo;

import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #3 — LOOP-CARRIED TAINT × SSRF (CWE-918). Taint flows through a loop into
 * the fetch sink. A method with NO finding is a FALSE NEGATIVE.
 */
public class LoopTaintSsrf {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("u");
        String[] urls = new String[in.length];
        for (int i = 0; i < in.length; i++) {
            urls[i] = in[i];
        }
        new URL(urls[0]).openStream();   // taint via array element -> CWE-918
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String acc = "https://";
        for (String p : req.getParameterValues("p")) {
            acc += p;
        }
        new URL(acc).openStream();       // accumulated tainted URL -> CWE-918
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String u : req.getParameterValues("u")) {
            new URL(u).openStream();     // CWE-918 per iteration
        }
    }
}
