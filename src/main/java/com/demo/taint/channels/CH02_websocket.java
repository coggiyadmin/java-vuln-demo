package com.demo.taint.channels;
import javax.servlet.http.*;
import java.io.*;
public class CH02_websocket {
  public void onMessage(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String payload = req.getParameter("msg"); // SOURCE websocket frame
    res.getWriter().print("<p>" + payload + "</p>"); // SINK CWE-79
  }
}
