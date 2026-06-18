package com.demo;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;

/** Combinations #6/#7/#8 — SANITIZER handling × PATH TRAVERSAL (CWE-22). */
public class SanitizerCombosPathTrav {

    private static final String BASE = "/srv/app/data/";

    private static String escapeHtml(String s) { return s.replace("<", "_").replace(">", "_"); } // wrong-context
    private static String sanitize(String s) { return s; }                                       // fake
    private static String checked(String s) { return new File(s).getName(); }                    // real wrapper (basename)

    // #6 WRONG-CONTEXT — HTML escape useless for path traversal; should still fire
    public void wrong(HttpServletRequest req) throws Exception {
        new FileInputStream(BASE + escapeHtml(req.getParameter("name"))); // CWE-22
    }

    // #7 FAKE sanitizer — no-op; should fire
    public void fake(HttpServletRequest req) throws Exception {
        new FileInputStream(BASE + sanitize(req.getParameter("name"))); // CWE-22
    }

    // #8 CUSTOM-WRAPPER — basename confines to BASE; should NOT fire
    public void wrapped(HttpServletRequest req) throws Exception {
        new FileInputStream(BASE + checked(req.getParameter("name"))); // expect 0 (FP if fires)
    }
}
