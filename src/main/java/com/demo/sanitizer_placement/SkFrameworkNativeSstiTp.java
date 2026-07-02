package com.demo.sanitizer_placement;
import java.sql.*;
import javax.servlet.http.*;
public class SkFrameworkNativeSstiTp {
  public void handle(HttpServletRequest req) throws Exception {
    String uid = org.owasp.encoder.Encode.forHtml(req.getParameter("uid"));
    Statement s = DriverManager.getConnection("jdbc:sqlite::memory:").createStatement();
    s.executeQuery("SELECT * FROM u WHERE n='" + uid + "'");
  }
}
