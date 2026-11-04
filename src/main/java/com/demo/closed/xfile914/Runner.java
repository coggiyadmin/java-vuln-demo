package com.demo.closed.xfile914;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// cognium-dev#914 — a constant argument through that helper stays clean
public class Runner extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String bar = "safe";
    String cmd = Utils.shellCommand("ls ");
    String[] args = new String[] {"sh", "-c", cmd + bar};
    Runtime.getRuntime().exec(args);
  }
}
