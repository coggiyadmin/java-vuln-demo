package com.demo.taint.channels;
import javax.servlet.http.*;
public class CH04_serverless {
  public void handler(HttpServletRequest req) throws Exception {
    String q = req.getParameter("q"); // SOURCE event field
    Runtime.getRuntime().exec("grep " + q); // SINK CWE-78
  }
}
