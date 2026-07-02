package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeXssTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String q = req.getParameter("q");
    resp.getWriter().write("<p>" + q + "</p>");
  }
}
