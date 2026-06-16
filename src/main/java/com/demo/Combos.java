package com.demo;

import java.sql.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination matrix — Java remaining cells (#2,3,4,6,7,8,9,11,13).
 * Source HttpServletRequest.getParameter → Statement.executeQuery / Runtime.exec.
 * FN probes must FIRE; #8 & #9 are FP probes.
 */
public class Combos {

    // #2 path-sensitivity — tainted used in failure branch
    public ResultSet c2(HttpServletRequest req, Connection c) throws SQLException {
        String u = req.getParameter("u");
        if (u != null && u.length() > 1000) {
            return c.createStatement().executeQuery("SELECT * FROM t WHERE n = " + u); // CWE-89
        }
        return null;
    }

    // #3 loop-carried — iterate over tainted values
    public void c3(HttpServletRequest req, Connection c) throws SQLException {
        for (String v : req.getParameterValues("p")) {
            c.createStatement().executeQuery("SELECT * FROM t WHERE n = " + v); // CWE-89
        }
    }

    // #4 async — taint captured into an async task
    public void c4(HttpServletRequest req) {
        String cmd = req.getParameter("cmd");
        CompletableFuture.runAsync(() -> {
            try { Runtime.getRuntime().exec(cmd); } catch (Exception e) {} // CWE-78
        });
    }

    // #6 wrong-context — URL-encode (xss/ssrf san) before COMMAND sink → should FIRE
    public void c6(HttpServletRequest req) throws Exception {
        String u = java.net.URLEncoder.encode(req.getParameter("u"), "UTF-8");
        Runtime.getRuntime().exec("echo " + u); // CWE-78
    }

    // #7 fake sanitizer — no-op
    private String clean(String x) { return x; }
    public void c7(HttpServletRequest req) throws Exception {
        Runtime.getRuntime().exec("echo " + clean(req.getParameter("u"))); // CWE-78
    }

    // #8 custom wrapper — wraps a real encoder (FP risk: should NOT fire for that context)
    private String myEsc(String x) { return org.owasp.encoder.Encode.forHtml(x); }
    public String c8(HttpServletRequest req) {
        return "<div>" + myEsc(req.getParameter("u")) + "</div>"; // xss-safe via wrapper → should NOT fire
    }

    // #9 comment/string-literal — sink syntax only in a string (FP: stay clean)
    public String c9(HttpServletRequest req) {
        // Runtime.getRuntime().exec(req.getParameter("u"));  <- comment, must not fire
        return "Runtime.getRuntime().exec(userInput)";        // literal, must not fire
    }

    // #11 fan-out — one source → two sinks
    public void c11(HttpServletRequest req, Connection c) throws Exception {
        String u = req.getParameter("u");
        Runtime.getRuntime().exec("echo " + u);                       // sink 1 (cmd)
        c.createStatement().executeQuery("SELECT * FROM t WHERE n = " + u); // sink 2 (sql)
    }

    // #13 encoded — base64 decode then sink
    public void c13(HttpServletRequest req) throws Exception {
        String cmd = new String(Base64.getDecoder().decode(req.getParameter("d")));
        Runtime.getRuntime().exec(cmd); // CWE-78
    }
}
