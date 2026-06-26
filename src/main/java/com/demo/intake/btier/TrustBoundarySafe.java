package com.demo.intake.btier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/** Safe mirror — PAT-TRUST-01 (role from server session, not client param). */
public class TrustBoundarySafe {
    public boolean isAdmin(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) {
            return false;
        }
        Object role = session.getAttribute("userRole");
        return "admin".equals(role);
    }
}
