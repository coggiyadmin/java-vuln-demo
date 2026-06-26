package com.demo.flow.tier1.sqli;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.text.StringEscapeUtils;
import java.sql.*;
public class V08WrongContextTp {
    public void run(HttpServletRequest req) throws Exception {
        String n = StringEscapeUtils.escapeHtml4(req.getParameter("name"));
        DriverManager.getConnection("jdbc:sqlite::memory:")
          .createStatement().execute("SELECT * FROM users WHERE name='" + n + "'");
    }
}
