package com.demo.taint.sources;
import javax.servlet.http.*;
import java.io.IOException;
public class SrcQuery {
  public void handle(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String q = req.getParameter("q"); // SOURCE SRC-01
    Runtime.getRuntime().exec("grep " + q); // SINK CWE-78
  }
}
