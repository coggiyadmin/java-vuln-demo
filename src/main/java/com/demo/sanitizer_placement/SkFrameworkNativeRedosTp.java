package com.demo.sanitizer_placement;
import java.util.regex.*;
import javax.servlet.http.*;
public class SkFrameworkNativeRedosTp {
  public void handle(HttpServletRequest req) throws Exception {
    String pat = org.owasp.encoder.Encode.forHtml(req.getParameter('p'));
    Pattern.compile(pat).matcher(req.getParameter('t')).matches();
  }
}
