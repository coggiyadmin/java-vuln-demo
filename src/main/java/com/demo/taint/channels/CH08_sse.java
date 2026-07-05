package com.demo.taint.channels;
import javax.servlet.http.HttpServletRequest;
public class CH08_sse {
  public String stream(HttpServletRequest req) {
    String msg = req.getParameter("msg"); // SOURCE
    return "data: <p>" + msg + "</p>\n\n"; // SINK CWE-79
  }
}
