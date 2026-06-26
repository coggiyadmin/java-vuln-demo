package com.demo.taint.sources;
import javax.servlet.http.*;
public class SrcPath {
  public void handle(HttpServletRequest req) throws Exception {
    String uid = req.getPathInfo().replace("/", ""); // SOURCE SRC-02
    Runtime.getRuntime().exec("id " + uid);
  }
}
