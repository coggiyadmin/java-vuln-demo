package com.demo.intake.btier;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletRequest;

/** B-tier PAT-INPUT-01 — unbounded transfer amount (CWE-20). CVE-2026-34197 catalog ref. */
public class InputValidationTp {
    public void transfer(HttpServletRequest req) throws Exception {
        int amount = Integer.parseInt(req.getParameter("amount")); // SINK CWE-20
        String toUser = req.getParameter("to");
        Connection db = DriverManager.getConnection("jdbc:sqlite:app.db");
        var ps = db.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE user = ?");
        ps.setInt(1, amount);
        ps.setString(2, toUser);
        ps.executeUpdate();
    }
}
