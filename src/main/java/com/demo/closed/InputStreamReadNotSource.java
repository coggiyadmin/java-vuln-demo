package com.demo.closed;
import javax.servlet.http.*;
// cognium-dev#1113 — InputStream.read(buf) is a byte count, not file input
public class InputStreamReadNotSource extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String bar = "constant";
    java.security.MessageDigest md = java.security.MessageDigest.getInstance("sha-384");
    byte[] input = {(byte) '?'};
    Object inputParam = bar;
    if (inputParam instanceof String) input = ((String) inputParam).getBytes();
    if (inputParam instanceof java.io.InputStream) {
      byte[] strInput = new byte[1000];
      int i = ((java.io.InputStream) inputParam).read(strInput);
      if (i == -1) return;
      input = java.util.Arrays.copyOf(strInput, i);
    }
    md.update(input);
    response.getWriter().println("Sensitive value '" + new String(input) + "' hashed");
  }
}
