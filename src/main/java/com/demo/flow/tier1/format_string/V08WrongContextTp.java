package com.demo.flow.tier1.format_string;
import javax.servlet.http.*;
import java.sql.*;
public class V08WrongContextTp {
    public void greet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String name = req.getParameter("name");
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM u WHERE n='" + name + "'");
        res.getWriter().printf("Hello %s", name);
    }
}
