package com.demo;

import java.sql.*;
import javax.servlet.http.*;

/**
 * DEMO FILE — header/cookie/second-order taint probes.
 */
public class HeaderCases {

    // CWE-89 — SQL injection from Authorization header (not query param).
    public ResultSet authLookup(HttpServletRequest request, Connection conn) throws SQLException {
        String auth = request.getHeader("Authorization");
        String token = auth != null ? auth.replace("Bearer ", "") : "";
        return conn.createStatement().executeQuery(
            "SELECT * FROM sessions WHERE token = '" + token + "'");  // CWE-89
    }

    // CWE-78 — cookie value passed to shell command.
    public Process cookieExec(HttpServletRequest request) throws Exception {
        String region = "us";
        for (Cookie c : request.getCookies()) {
            if ("region".equals(c.getName())) region = c.getValue();
        }
        return Runtime.getRuntime().exec("geoip-lookup " + region);  // CWE-78
    }

    // CWE-89 — second-order: DB value reused unsanitized in ORDER BY.
    public ResultSet secondOrder(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet pref = st.executeQuery("SELECT sort_col FROM prefs WHERE id = 1");
        String col = pref.next() ? pref.getString("sort_col") : "name";
        return conn.createStatement().executeQuery("SELECT * FROM users ORDER BY " + col);  // CWE-89
    }
}
