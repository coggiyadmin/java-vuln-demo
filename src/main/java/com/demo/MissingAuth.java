package com.demo;

import java.sql.Connection;
import java.sql.Statement;

/** CWE-306 — Missing Authentication for Critical Function. A destructive operation runs with
 * no authentication/authorization check. (Engine gap / partial.) FN probe. */
public class MissingAuth {
    public void purge(Connection c) throws Exception {
        // no auth check on a destructive, privileged action → CWE-306
        try (Statement s = c.createStatement()) {
            s.executeUpdate("DELETE FROM users");
        }
    }
}
