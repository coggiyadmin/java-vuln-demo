package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkFakePathtravTp {
  public void handle(HttpServletRequest req) throws Exception {
    String p = req.getParameter("p").replaceFirst("^/+", "");
    new FileInputStream("/data/" + p);
  }
}
