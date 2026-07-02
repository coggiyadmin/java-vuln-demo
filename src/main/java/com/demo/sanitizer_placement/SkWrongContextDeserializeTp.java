package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkWrongContextDeserializeTp {
  public Object handle(HttpServletRequest req) throws Exception {
    byte[] b = req.getParameter("s").replace("<", "&lt;").getBytes();
    return new ObjectInputStream(new ByteArrayInputStream(b)).readObject();
  }
}
