package com.demo.sanitizer_placement;
import java.net.*;
import javax.servlet.http.*;
public class SkFakeSsrfTp {
  public void handle(HttpServletRequest req) throws Exception {
    String u = req.getParameter("url");
    new URL("https://api.example.com/" + u).openStream();
  }
}
