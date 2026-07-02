package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeCmdiTp {
  public void handle(HttpServletRequest req) throws Exception {
    String cmd = org.owasp.encoder.Encode.forHtml(req.getParameter('cmd'));
    Runtime.getRuntime().exec(cmd);
  }
}
