package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperXssTp {
  private static String companySanitize(String v) {
    return v.replace("<", "").replace(">", "");
  }
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String q = companySanitize(req.getParameter("q"));
    resp.getWriter().write("<p>" + q + "</p>");
  }
}
