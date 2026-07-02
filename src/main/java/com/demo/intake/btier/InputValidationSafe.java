package com.demo.intake.btier;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletRequest;

/** B-tier PAT-INPUT-01 safe — bounded transfer amount. */
public class InputValidationSafe {
    public void transfer(HttpServletRequest req) throws Exception {
        int amount = Integer.parseInt(req.getParameter("amount"));
        if (amount < 1 || amount > 10_000) {
            throw new IllegalArgumentException("amount out of range");
        }
        String toUser = req.getParameter("to");
        Connection db = DriverManager.getConnection("jdbc:sqlite:app.db");
        var ps = db.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE user = ?");
        ps.setInt(1, amount);
        ps.setString(2, toUser);
        ps.executeUpdate();
    }
}
