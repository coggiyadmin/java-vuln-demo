package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkWrongContextCrlfTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) {
    String loc = req.getParameter("url").replace("'", "''");
    resp.setHeader("Location", loc);
  }
}
