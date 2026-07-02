package com.demo.intake.btier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/** B-tier PAT-PRIV-01 — query flag grants admin role (CWE-269). */
public class PrivilegeEscalationTp {
    public void elevate(HttpServletRequest req) {
        if ("1".equals(req.getParameter("admin"))) {
            HttpSession session = req.getSession();
            session.setAttribute("role", "admin"); // SINK CWE-269
        }
    }
}
