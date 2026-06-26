package com.demo.flow.tier1.sqli;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("'", ""); }
    public void run(HttpServletRequest req) throws Exception {
        String n = companySanitize(req.getParameter("name"));
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM users WHERE name='" + n + "'");
    }
}
