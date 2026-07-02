package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkHardeningCmdiTp {
  public void handle(HttpServletRequest req) throws Exception {
    String cmd = req.getParameter('cmd').replace(';', '');
    Runtime.getRuntime().exec(cmd);
  }
}
