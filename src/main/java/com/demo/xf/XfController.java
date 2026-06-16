package com.demo.xf;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
public class XfController {
    public ResultSet handle(HttpServletRequest req, Connection c) throws SQLException {
        String name = req.getParameter("u");       // SOURCE
        return XfHelper.run(c, name);                // cross-file call
    }
}
