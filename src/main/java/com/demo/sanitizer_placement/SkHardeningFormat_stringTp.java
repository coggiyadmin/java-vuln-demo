package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningFmtstrTp {
  public void handle(HttpServletRequest req) {
    String pat = req.getParameter("fmt");
    if (pat.length() > 32) pat = "%s";
    String.format(pat, "guest");
  }
}
