package com.demo.libapi;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/** TP anchor — user-controlled SQLException message (#157). */
public class SqlExceptionUserTp {
    public void fail(HttpServletRequest req) throws SQLException {
        throw new SQLException(req.getParameter("msg"));
    }
}
