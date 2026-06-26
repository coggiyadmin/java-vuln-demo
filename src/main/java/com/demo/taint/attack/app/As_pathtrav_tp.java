package com.demo.taint.attack.app;
import javax.servlet.http.*;
import java.nio.file.*;
public class As_pathtrav_app {
  public void read(HttpServletRequest req) throws Exception {
    Files.readString(Path.of("/data", req.getParameter("p")));
  }
}
