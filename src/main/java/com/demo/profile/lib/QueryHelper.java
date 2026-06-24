// FP-target (elarasu cognium-dev#128/#169) — LIBRARY profile. A public reusable helper; its
// `filter` parameter is supplied by *calling code*, not an HTTP entry point. With an
// entry-point gate, this must NOT be sql_injection (no attacker-reachable source).
package com.demo.profile.lib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public final class QueryHelper {
    private QueryHelper() {}
    public static ResultSet byFilter(Connection c, String filter) throws Exception {
        Statement st = c.createStatement();
        return st.executeQuery("SELECT * FROM items WHERE " + filter); // not entry-point-reachable
    }
}
