package com.demo.flow.tier1.trust_boundary;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/** Safe mirror — allowlisted role before session write (CWE-501). */
public class V01BaselineSafe {
    private static final Set<String> ALLOWED = Set.of("user", "viewer", "admin");

    public void save(HttpServletRequest req) {
        String role = req.getParameter("role");
        if (role == null || !ALLOWED.contains(role)) {
            return;
        }
        req.getSession().setAttribute("role", role);
    }
}
