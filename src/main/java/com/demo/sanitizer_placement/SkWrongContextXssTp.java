package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkWrongContextXssTp {
  public void handle(HttpServletRequest req) {
    String q = req.getParameter("q").replace("'", "''");
    req.setAttribute("out", "<p>" + q + "</p>");
  }
}
