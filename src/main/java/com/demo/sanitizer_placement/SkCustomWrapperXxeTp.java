package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
public class SkCustomWrapperXxeTp {
  private static byte[] companySanitize(byte[] raw) {
    return new String(raw).replace("ENTITY", "").getBytes();
  }
  public void handle(HttpServletRequest req) throws Exception {
    DocumentBuilderFactory.newInstance().newDocumentBuilder()
        .parse(new ByteArrayInputStream(companySanitize(req.getInputStream().readAllBytes())));
  }
}
