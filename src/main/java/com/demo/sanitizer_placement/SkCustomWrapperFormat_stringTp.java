package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperFmtstrTp {
  private static String companySanitize(String v) { return v.replace("%", ""); }
  public void handle(HttpServletRequest req) {
    String pat = companySanitize(req.getParameter("fmt"));
    String.format(pat, "guest");
  }
}
