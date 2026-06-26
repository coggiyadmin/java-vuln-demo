package com.demo.intake;

import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** TP — fetches user URL (CWE-918). CVE-2020-7796 B-tier class. */
public class SsrfFetchTp {
    public void fetch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String u = req.getParameter("url");
        new URL(u).openStream(); // SINK CWE-918
        resp.sendRedirect(u);
    }
}
