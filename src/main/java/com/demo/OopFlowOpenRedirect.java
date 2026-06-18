package com.demo;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Combination #5 — OOP OBJECT FLOW × OPEN REDIRECT (CWE-601). Taint is injected
 * via the constructor, stored in a field, exposed through a getter, and reaches a
 * sendRedirect sink. Each is a REAL open redirect; NO finding = FALSE NEGATIVE.
 */
public class OopFlowOpenRedirect {

    private final String url;     // taint-carrying field

    public OopFlowOpenRedirect(HttpServletRequest req) {
        this.url = req.getParameter("next");   // constructor-injected taint
    }

    public String getUrl() {
        return this.url;          // getter exposes the tainted field
    }

    // 5a. field read directly in a sink method
    public void goDirect(HttpServletResponse resp) throws IOException {
        resp.sendRedirect(this.url);          // open-redirect sink (CWE-601)
    }

    // 5b. field read via getter into a sink
    public void goViaGetter(HttpServletResponse resp) throws IOException {
        resp.sendRedirect(getUrl());          // open-redirect sink (CWE-601)
    }
}
