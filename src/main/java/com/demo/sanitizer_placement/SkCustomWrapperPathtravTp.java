package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkCustomWrapperPathtravTp {
  private static String companySanitize(String v) { return v.replaceFirst("^/+", ""); }
  public void handle(HttpServletRequest req) throws Exception {
    String p = companySanitize(req.getParameter("p"));
    new FileInputStream("/data/" + p);
  }
}
