package com.demo.intake.btier;

import javax.servlet.http.HttpServletRequest;

/** Safe mirror — PAT-PRIV-01 (role from server-side auth only). */
public class PrivilegeEscalationSafe {
    public boolean isAdmin(HttpServletRequest req) {
        Object role = req.getSession(false) == null ? null : req.getSession(false).getAttribute("userRole");
        return "admin".equals(role);
    }
}
