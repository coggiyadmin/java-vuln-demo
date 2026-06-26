package com.demo.taint.sanitize.kinds;
import javax.servlet.http.*;
public class SK01_ssrf {
  public void handle(HttpServletRequest req) throws Exception {
    String n = req.getParameter("n");
    if (!n.matches("[A-Za-z0-9]+")) throw new SecurityException();
    java.sql.DriverManager.getConnection("jdbc:sqlite::memory:")
      .createStatement().execute("SELECT * FROM u WHERE n='" + n + "'"); // SK-01 validate partial
  }
}
