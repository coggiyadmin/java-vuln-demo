package com.demo;

import java.io.FileInputStream;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Combination #11 — FAN-OUT / dedup. One tainted source reaches multiple distinct web
 * sinks; expect one finding per sink type.
 */
public class FanoutWeb {

    public void fanout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String u = req.getParameter("u");              // single SOURCE
        new FileInputStream("/srv/app/data/" + u);     // sink 1 — path_traversal (CWE-22)
        new URL(u).openStream();                       // sink 2 — ssrf (CWE-918)
        resp.sendRedirect(u);                          // sink 3 — open_redirect (CWE-601)
    }
}
