package com.demo.intake.btier;

import javax.servlet.http.HttpServletRequest;

/** B-tier PAT-TRUST-01 — client-supplied role trusted for authorization (CWE-501). */
public class TrustBoundaryTp {
    public boolean isAdmin(HttpServletRequest req) {
        return "admin".equals(req.getParameter("role")); // SINK CWE-501 — trust client role
    }
}
