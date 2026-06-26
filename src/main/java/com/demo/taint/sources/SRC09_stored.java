package com.demo.taint.sources;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class SrcStored {
  static final Map<String,String> DB = Map.of("1", "<img onerror=alert(1)>");
  public void show(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String row = DB.get(req.getParameter("id")); // SOURCE SRC-09
    res.getWriter().print(row);
  }
}
