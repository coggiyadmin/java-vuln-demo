package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkFakeXssTp {
  public void handle(HttpServletRequest req) {
    String q = req.getParameter("q").replace("SANITIZE", "");
    req.setAttribute("out", "<p>" + q + "</p>");
  }
}
