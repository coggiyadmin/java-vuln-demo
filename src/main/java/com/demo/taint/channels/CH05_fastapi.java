package com.demo.taint.channels;
import javax.servlet.http.*;
import java.net.URL;
public class CH05_fastapi {
  public byte[] proxy(HttpServletRequest req) throws Exception {
    String url = req.getParameter("url");
    return new URL(url).openStream().readAllBytes(); // SINK CWE-918
  }
}
