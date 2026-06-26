package com.demo.flow.tier1.xss;
import java.io.*; import javax.servlet.http.*;
import java.sql.*;
public class V08WrongContextTp {
    public void render(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String q = req.getParameter("q");
        try {
            DriverManager.getConnection("jdbc:sqlite::memory:")
              .createStatement().execute("SELECT * FROM u WHERE n='" + q + "'");
        } catch (Exception ignored) {}
        res.getWriter().print("<h1>" + q + "</h1>");
    }
}
