package com.demo.sanitizer_placement;
import java.net.*;
import javax.servlet.http.*;
public class SkFrameworkNativeSsrfTp {
  public void handle(HttpServletRequest req) throws Exception {
    String url = org.owasp.encoder.Encode.forHtml(req.getParameter('url'));
    new URL(url).openStream();
  }
}
