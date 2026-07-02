package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkHardeningPathtravTp {
  public void handle(HttpServletRequest req) throws Exception {
    String p = new File(req.getParameter("p")).getName();
    new FileInputStream("/data/" + p);
  }
}
