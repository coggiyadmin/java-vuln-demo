package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningSstiTp {
  public void handle(HttpServletRequest req) {
    String n = req.getParameter('n');
    if (n.length() > 64) n = n.substring(0, 64);
    req.setAttribute('out', '<p>Hello ' + n + '</p>');
  }
}
