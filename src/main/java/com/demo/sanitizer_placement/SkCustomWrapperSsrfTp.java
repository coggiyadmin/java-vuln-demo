package com.demo.sanitizer_placement;
import java.net.*;
import javax.servlet.http.*;
public class SkCustomWrapperSsrfTp {
  private static String companySanitize(String v) {
    return v.replace("http://", "").replace("https://", "");
  }
  public void handle(HttpServletRequest req) throws Exception {
    String url = companySanitize(req.getParameter("url"));
    new URL("http://" + url).openStream();
  }
}
