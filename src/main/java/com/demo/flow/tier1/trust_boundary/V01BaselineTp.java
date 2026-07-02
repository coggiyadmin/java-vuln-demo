package com.demo.flow.tier1.trust_boundary;

import javax.servlet.http.HttpServletRequest;

/** TP (CWE-501) — untrusted parameter stored in trusted session. */
public class V01BaselineTp {
    public void save(HttpServletRequest req) {
        req.getSession().setAttribute("role", req.getParameter("role")); // SINK (CWE-501)
    }
}
