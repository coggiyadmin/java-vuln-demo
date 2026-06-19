package com.demo;

import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × loginj. */
public class EncodedLogInj {

    public void b64(HttpServletRequest req) {
        String u = new String(java.util.Base64.getDecoder().decode(req.getParameter("d")));
        java.util.logging.Logger.getLogger("app").info("actor " + u); // CWE-117
    }
    public void url(HttpServletRequest req) throws Exception {
        String u = java.net.URLDecoder.decode(req.getParameter("d"), "UTF-8");
        java.util.logging.Logger.getLogger("app").info("actor " + u); // CWE-117
    }
}
