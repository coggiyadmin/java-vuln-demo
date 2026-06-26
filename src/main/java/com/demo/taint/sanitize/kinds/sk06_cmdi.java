package com.demo.taint.sanitize.kinds;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
import java.sql.*;
public class SK06_cmdi {
  public void handle(HttpServletRequest req) throws Exception {
    String n = StringEscapeUtils.escapeHtml4(req.getParameter("n")); // wrong for SQL
    DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM u WHERE n='" + n + "'"); // SK-06 TP
  }
}
