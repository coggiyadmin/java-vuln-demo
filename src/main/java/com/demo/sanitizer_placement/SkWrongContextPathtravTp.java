package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkWrongContextPathtravTp {
  public void handle(HttpServletRequest req) throws Exception {
    String p = req.getParameter("p").replace("<", "&lt;");
    new FileInputStream("/data/" + p);
  }
}
