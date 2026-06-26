package com.demo.flow.tier1.ssrf;

import java.net.*;
import java.util.Set;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    private static final Set<String> ALLOWED = Set.of("api.internal.example.com");
    public void fetch(HttpServletRequest req) throws Exception {
        URL url = new URL(req.getParameter("url"));
        if (!ALLOWED.contains(url.getHost())) throw new SecurityException("forbidden");
        url.openStream();
    }
}
