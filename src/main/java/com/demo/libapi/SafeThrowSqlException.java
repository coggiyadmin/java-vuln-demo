// FP-target (upstream cognium-dev#157) — `throw new SQLException(msg)` is an error path, not a
// query execution; sql_injection must not resolve its sink to this line.
package com.demo.libapi;

import java.sql.SQLException;

public class SafeThrowSqlException {
    public void validate(String field) throws SQLException {
        if (field == null) throw new SQLException("missing field: " + field); // NOT a sink
    }
}
