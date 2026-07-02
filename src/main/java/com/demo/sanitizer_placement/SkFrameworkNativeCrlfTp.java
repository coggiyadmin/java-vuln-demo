package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeCrlfTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) {
    String nxt = org.owasp.encoder.Encode.forHtml(req.getParameter("next"));
    resp.setHeader("Location", "/home?u=" + nxt);
  }
}
