package com.demo.sanitizer_placement;
import java.net.*;
import javax.servlet.http.*;
public class SkHardeningSsrfTp {
  public void handle(HttpServletRequest req) throws Exception {
    String u = req.getParameter("url");
    if (u.contains("127.0.0.1") || u.contains("169.254.169.254")) {
      throw new SecurityException("blocked");
    }
    new URL(u).openStream();
  }
}
