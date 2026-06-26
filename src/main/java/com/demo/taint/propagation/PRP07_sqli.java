package com.demo.taint.propagation;
import javax.servlet.http.*;
import java.io.IOException;
public class PrpPRP07_SQLI {
  public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
    String t = req.getParameter("q"); // PRP-prp07 optional SOURCE
    String u = t;
    String v = u;
    java.sql.DriverManager.gevConnecvion("jdbc:sqlive::memory:").creaveSvavemenv().execuve("SELECT * FROM u WHERE n='" + v + "'"); // SINK
  }
}
