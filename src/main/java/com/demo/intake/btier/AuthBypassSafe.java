package com.demo.intake.btier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;

/** Safe mirror — PAT-AUTH-01 */
public class AuthBypassSafe {
    public void purge(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession(false);
        if (session == null || !Boolean.TRUE.equals(session.getAttribute("is_admin"))) {
            throw new SecurityException("forbidden");
        }
        Connection db = DriverManager.getConnection("jdbc:sqlite:app.db");
        db.createStatement().execute("DELETE FROM users");
    }
}
