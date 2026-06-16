package com.demo;

import java.sql.*;
import javax.servlet.http.*;

/**
 * DEMO FILE — cases derived from real 2025 vulnerability advisories.
 *
 *  - CVE-2025-25257 (Fortinet FortiWeb): pre-auth SQL injection where the
 *    tainted value arrives in an HTTP *header* (Authorization), not a query
 *    param — exercises http_header → SQL sink.
 *  - Second-order / stored injection: data read back from the DB is re-used in
 *    a new query without re-sanitization (a classic missed taint vector).
 *  - Cookie-sourced command injection.
 */
public class AdvisoryCases {

    // CVE-2025-25257 class — SQL injection from the Authorization HEADER
    public ResultSet authLookup(HttpServletRequest request, Connection conn) throws SQLException {
        String auth = request.getHeader("Authorization");   // http_header source
        String token = auth != null ? auth.replace("Bearer ", "") : "";
        // FortiWeb-style: header value concatenated into SQL → pre-auth SQLi
        return conn.createStatement().executeQuery(
            "SELECT * FROM sessions WHERE token = '" + token + "'");
    }

    // Cookie-sourced command injection
    public Process cookieExec(HttpServletRequest request) throws Exception {
        String region = "us";
        for (Cookie c : request.getCookies()) {              // http_cookie source
            if ("region".equals(c.getName())) region = c.getValue();
        }
        return Runtime.getRuntime().exec("geoip-lookup " + region);
    }

    // SECOND-ORDER / stored injection — DB read flows into a new query
    public ResultSet secondOrder(Connection conn) throws SQLException {
        Statement st = conn.createStatement();
        ResultSet pref = st.executeQuery("SELECT sort_col FROM prefs WHERE id = 1");
        String col = pref.next() ? pref.getString("sort_col") : "name";  // db_input source
        // value originally attacker-stored, now used unsanitized → stored SQLi
        return conn.createStatement().executeQuery("SELECT * FROM users ORDER BY " + col);
    }
}
