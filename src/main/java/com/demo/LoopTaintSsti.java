package com.demo;

import freemarker.template.*;
import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;

/**
 * Combination #3 — LOOPTAINT × SSTI (CWE-1336).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintSsti {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("t");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String t = items[0];
        new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); // CWE-1336
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String t = "";
        for (String x : req.getParameterValues("t")) { t += x; }
        new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); // CWE-1336
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String t : req.getParameterValues("t")) {
            new Template("t", t, new Configuration(Configuration.VERSION_2_3_31)).process(null, new StringWriter()); // CWE-1336 per iteration
        }
    }

}
