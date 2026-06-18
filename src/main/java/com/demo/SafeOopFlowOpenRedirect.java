package com.demo;

import java.io.IOException;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SAFE mirror — OopFlowOpenRedirect; the tainted target is constrained to a
 * relative same-site path before redirect. Expect 0 security findings.
 */
public class SafeOopFlowOpenRedirect {

    private final String url;

    public SafeOopFlowOpenRedirect(HttpServletRequest req) {
        this.url = req.getParameter("next");
    }

    private String safeDest() {
        URI u = URI.create(this.url);
        if (u.isAbsolute() || u.getHost() != null) {   // reject absolute / cross-host
            return "/";
        }
        return "/" + u.getPath().replaceFirst("^/+", "");
    }

    public void goDirect(HttpServletResponse resp) throws IOException {
        resp.sendRedirect(safeDest());     // only same-site relative paths
    }
}
