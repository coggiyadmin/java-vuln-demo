package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeFmtstrTp {
  public void handle(HttpServletRequest req) {
    String pat = req.getParameter("fmt");
    String name = org.owasp.encoder.Encode.forHtml(req.getParameter("name"));
    String.format(pat, name);
  }
}
