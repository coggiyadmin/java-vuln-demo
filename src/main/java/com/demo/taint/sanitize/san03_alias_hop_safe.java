package com.demo.taint.sanitize;
import javax.servlet.http.*;
public class SAN03_safe {
  public void handle(HttpServletRequest req) throws Exception {
    Runtime.getRuntime().exec("grep " + java.net.URLEncoder.encode(req.getParameter("q"), "UTF-8") + " /var/log/app.log");
  }
}
