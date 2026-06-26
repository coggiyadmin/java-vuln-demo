package com.demo.intake;

import java.io.InputStream;
import java.net.URL;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/** Safe mirror — host allowlist before fetch. */
public class SsrfFetchSafe {
    private static final Set<String> ALLOWED = Set.of("api.internal.example.com", "cdn.example.com");

    public InputStream fetch(HttpServletRequest req) throws Exception {
        URL url = new URL(req.getParameter("url"));
        if (!ALLOWED.contains(url.getHost())) {
            throw new SecurityException("forbidden host");
        }
        return url.openStream();
    }
}
