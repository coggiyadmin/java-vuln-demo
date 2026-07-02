package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkHardeningDeserializeTp {
  public void handle(HttpServletRequest req) throws Exception {
    byte[] blob = req.getInputStream().readAllBytes();
    if (blob.length > 65536) throw new SecurityException("too large");
    new ObjectInputStream(new ByteArrayInputStream(blob)).readObject();
  }
}
