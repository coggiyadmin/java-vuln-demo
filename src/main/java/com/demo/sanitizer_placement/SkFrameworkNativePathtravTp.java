package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkFrameworkNativePathtravTp {
  public void handle(HttpServletRequest req) throws Exception {
    String p = org.owasp.encoder.Encode.forHtml(req.getParameter('p'));
    new FileInputStream('/data/' + p);
  }
}
