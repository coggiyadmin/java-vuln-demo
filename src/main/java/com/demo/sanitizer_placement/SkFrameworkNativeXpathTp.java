package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFrameworkNativeXpathTp {
  public void handle(HttpServletRequest req) throws Exception {
    String q = org.owasp.encoder.Encode.forHtml(req.getParameter('q'));
    javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate("//u[@n='" + q + "']", new org.w3c.dom.Document() {});
  }
}
