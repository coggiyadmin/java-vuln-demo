package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkFakeDeserializeTp {
  public Object handle(HttpServletRequest req) throws Exception {
    byte[] b = req.getParameter("s").replace("SAFE", "").getBytes();
    return new ObjectInputStream(new ByteArrayInputStream(b)).readObject();
  }
}
