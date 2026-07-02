package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeXxeTp {
  public void handle(HttpServletRequest req) throws Exception {
    String xml = org.owasp.encoder.Encode.forHtml(new String(req.getInputStream().readAllBytes()));
    javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(xml.getBytes()));
  }
}
