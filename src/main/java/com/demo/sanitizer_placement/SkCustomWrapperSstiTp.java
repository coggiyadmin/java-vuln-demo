package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperSstiTp {
  private static String companySanitize(String v) { return v.replace("{{", "").replace("}}", ""); }
  public void handle(HttpServletRequest req) {
    String n = companySanitize(req.getParameter("n"));
    req.setAttribute("out", "<p>Hello " + n + "</p>");
  }
}
