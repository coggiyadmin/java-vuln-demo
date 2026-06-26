package com.demo.taint.attack.cli;
import javax.servlet.http.*;
import java.nio.file.*;
public class As_pathtrav_cli {
  public void read(HttpServletRequest req) throws Exception {
    Files.readString(Path.of("/data", req.getParameter("p")));
  }
}
