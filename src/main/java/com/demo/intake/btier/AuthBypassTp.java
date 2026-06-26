package com.demo.intake.btier;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;

/** B-tier PAT-AUTH-01 — admin action without auth check (CWE-306). */
public class AuthBypassTp {
    public void purge(HttpServletRequest req) throws Exception {
        Connection db = DriverManager.getConnection("jdbc:sqlite:app.db");
        db.createStatement().execute("DELETE FROM users"); // SINK CWE-306
    }
}
