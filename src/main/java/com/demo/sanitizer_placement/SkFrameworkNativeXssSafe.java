package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeXssSafe {
  public void handle(HttpServletRequest req) {
    String q = req.getParameter("q");
    req.setAttribute("out", "<p>" + org.owasp.encoder.Encode.forHtml(q) + "</p>");
  }
}
