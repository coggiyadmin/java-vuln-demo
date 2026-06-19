package com.demo;

import javax.servlet.http.HttpServletRequest;

/** CWE-426 — Untrusted Search Path. ProcessBuilder invokes a bare binary name resolved via
 * $PATH; an attacker-controlled PATH entry runs a malicious binary. (Engine gap.) FN probe. */
public class UntrustedSearchPath {
    public Process thumb(HttpServletRequest req) throws Exception {
        String src = req.getParameter("src");
        return new ProcessBuilder("convert", src, "out.png").start(); // 'convert' via $PATH → CWE-426
    }
}
