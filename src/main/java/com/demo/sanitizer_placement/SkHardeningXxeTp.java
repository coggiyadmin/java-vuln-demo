package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
public class SkHardeningXxeTp {
  public void handle(HttpServletRequest req) throws Exception {
    if (req.getContentLengthLong() > 65536) throw new SecurityException("too large");
    DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(req.getInputStream());
  }
}
