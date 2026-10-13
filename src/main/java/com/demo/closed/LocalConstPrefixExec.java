package com.demo.closed;
import javax.servlet.http.*;
import java.io.IOException;
// cognium-dev#627 — local constant prefix plus tainted value
public class LocalConstPrefixExec extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String bar = request.getParameter("q");
    String cmd = "echo ";
    Runtime r = Runtime.getRuntime();
    try { r.exec(cmd + bar); } catch (IOException e) { } // SINK CWE-78
  }
}
