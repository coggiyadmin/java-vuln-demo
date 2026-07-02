package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeOpenredirectTp {
  public void handle(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String nxt = org.owasp.encoder.Encode.forHtml(req.getParameter('next'));
    resp.sendRedirect(nxt);
  }
}
