package com.demo;

import java.io.InputStream;
import java.net.URL;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — OopFlowSsrf; the tainted host is validated against an allowlist
 * inside the object before the request. Expect 0 security findings.
 */
public class SafeOopFlowSsrf {

    private static final Set<String> ALLOWED = Set.of("api.internal.example.com");
    private final String url;

    public SafeOopFlowSsrf(HttpServletRequest req) {
        this.url = req.getParameter("url");
    }

    private URL checked() throws Exception {
        URL u = new URL(this.url);
        if (!ALLOWED.contains(u.getHost())) {     // allowlist enforced before sink
            throw new SecurityException("host not allowed");
        }
        return u;
    }

    public InputStream fetchDirect() throws Exception {
        return checked().openStream();            // only allowlisted hosts reach the sink
    }
}
