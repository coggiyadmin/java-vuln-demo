package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** CWE-93 — CRLF Injection. User input with CR/LF set into a response header. FN probe. */
public class CrlfInjection {
    public void track(HttpServletRequest req, HttpServletResponse resp) {
        String val = req.getParameter("v");   // SOURCE
        resp.setHeader("X-Track", val);        // CR/LF injects/splits headers → CWE-93
    }
}
