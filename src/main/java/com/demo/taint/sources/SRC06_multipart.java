package com.demo.taint.sources;
import javax.servlet.http.*;
import java.nio.file.*;
public class SrcMultipart {
  public void handle(HttpServletRequest req) throws Exception {
    String name = req.getHeader("X-Filename"); // SOURCE SRC-06 stub
    Files.write(Path.of("/tmp", name), new byte[0]);
  }
}
