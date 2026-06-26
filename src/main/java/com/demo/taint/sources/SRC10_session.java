package com.demo.taint.sources;
import javax.servlet.http.*;
import java.io.*;
public class SrcSession {
  public void show(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String v = (String) req.getSession().getAttribute("msg"); // SOURCE SRC-10
    res.getWriter().print("<p>" + v + "</p>");
  }
}
