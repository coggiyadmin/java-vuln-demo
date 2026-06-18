package com.demo;

import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #3 — LOOP-CARRIED TAINT × PATH TRAVERSAL (CWE-22).
 */
public class LoopTaintPathTrav {

    private static final String BASE = "/srv/app/data/";

    public void viaList(HttpServletRequest req) throws Exception {
        String[] in = req.getParameterValues("n");
        String[] names = new String[in.length];
        for (int i = 0; i < in.length; i++) {
            names[i] = in[i];
        }
        new FileInputStream(BASE + names[0]); // CWE-22
    }

    public void viaAccum(HttpServletRequest req) throws Exception {
        String p = BASE;
        for (String seg : req.getParameterValues("seg")) {
            p += seg;
        }
        new FileInputStream(p); // CWE-22
    }

    public void viaIter(HttpServletRequest req) throws Exception {
        for (String n : req.getParameterValues("n")) {
            new FileInputStream(BASE + n); // CWE-22
        }
    }
}
