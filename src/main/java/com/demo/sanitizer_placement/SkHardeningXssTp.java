package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningXssTp {
  public void handle(HttpServletRequest req) {
    String q = req.getParameter('q').replace('<script', '');
    req.setAttribute('out', '<p>' + q + '</p>');
  }
}
