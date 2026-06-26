package com.demo.taint.sources;
import javax.servlet.http.*;
public class SrcHeader {
  public void handle(HttpServletRequest req) throws Exception {
    String ua = req.getHeader("User-Agent"); // SOURCE SRC-03
    Runtime.getRuntime().exec("echo " + ua);
  }
}
