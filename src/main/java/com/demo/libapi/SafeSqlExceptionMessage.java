package com.demo.libapi;

import java.sql.SQLException;

/** TN — throw SQLException with static message (#157). */
public class SafeSqlExceptionMessage {
    public void fail() throws SQLException {
        throw new SQLException("connection reset");
    }
}
