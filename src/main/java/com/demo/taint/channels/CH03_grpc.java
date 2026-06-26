package com.demo.taint.channels;
import javax.servlet.http.*;
public class CH03_grpc {
  public void handle(HttpServletRequest req) throws Exception {
    String payload = req.getParameter("payload"); // SOURCE gRPC field
    Runtime.getRuntime().exec("echo " + payload); // SINK CWE-78
  }
}
