package com.demo;

import java.io.InputStream;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #5 — OOP OBJECT FLOW × SSRF (CWE-918). Taint is injected via the
 * constructor, stored in a field, exposed through a getter, and reaches a
 * URL-open sink. Each is a REAL SSRF; NO finding = FALSE NEGATIVE.
 */
public class OopFlowSsrf {

    private final String url;     // taint-carrying field

    public OopFlowSsrf(HttpServletRequest req) {
        this.url = req.getParameter("url");   // constructor-injected taint
    }

    public String getUrl() {
        return this.url;          // getter exposes the tainted field
    }

    // 5a. field read directly in a sink method
    public InputStream fetchDirect() throws Exception {
        return new URL(this.url).openStream();        // SSRF sink (CWE-918)
    }

    // 5b. field read via getter into a sink
    public InputStream fetchViaGetter() throws Exception {
        return new URL(getUrl()).openStream();        // SSRF sink (CWE-918)
    }
}
