package com.demo.taint.sources;
import javax.servlet.http.*;
import java.io.*;
public class SrcBody {
  public void handle(HttpServletRequest req) throws Exception {
    String q = req.getReader().lines().reduce("", String::concat); // SOURCE SRC-05 stub
    Runtime.getRuntime().exec("grep " + q);
  }
}
