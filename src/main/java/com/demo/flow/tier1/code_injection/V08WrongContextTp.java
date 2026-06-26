package com.demo.flow.tier1.code_injection;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class V08WrongContextTp {
    public String run(HttpServletRequest req) throws Exception {
        String x = req.getParameter("x");
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT " + x);
        return x; // SQL concat wrong for code injection TP
    }
}
