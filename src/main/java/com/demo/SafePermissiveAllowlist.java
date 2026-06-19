package com.demo;

import java.net.URI;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — PermissiveAllowlist.java; exact host allow-list (parsed authority equality).
 */
public class SafePermissiveAllowlist {

    private static final Set<String> ALLOWED_HOSTS = Set.of("trusted.com", "www.trusted.com");

    public void fetch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String host = URI.create(request.getParameter("url")).getHost();
        if (host == null || !ALLOWED_HOSTS.contains(host)) {   // exact-match allow-list
            response.sendError(400, "blocked");
            return;
        }
        response.sendRedirect(request.getParameter("url"));
    }
}
