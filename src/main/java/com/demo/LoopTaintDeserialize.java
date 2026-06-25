package com.demo;

import java.io.*;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #3 — LOOPTAINT × DESERIALIZE (CWE-502).
 * A method with NO finding is a FALSE NEGATIVE (unless noted safe).
 */
public class LoopTaintDeserialize {

    // 3a. ARRAY ELEMENT BUILT IN LOOP
    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("s");
        String[] items = new String[in.length];
        for (int i = 0; i < in.length; i++) { items[i] = in[i]; }
        String s = items[0];
        new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); // CWE-502
    }

    // 3b. STRING ACCUMULATOR
    public void viaAccum(HttpServletRequest req) throws Exception {
        String s = "";
        for (String x : req.getParameterValues("s")) { s += x; }
        new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); // CWE-502
    }

    // 3c. ITERATE-AND-SINK
    public void viaIter(HttpServletRequest req) throws Exception {
        for (String s : req.getParameterValues("s")) {
            new ObjectInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(s))).readObject(); // CWE-502 per iteration
        }
    }

}
