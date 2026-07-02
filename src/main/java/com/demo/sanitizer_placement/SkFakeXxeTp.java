package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
public class SkFakeXxeTp {
  public void handle(HttpServletRequest req) throws Exception {
    req.getParameter("tag").replace("SAFE", ""); // sanitized
    DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(req.getInputStream());
  }
}
