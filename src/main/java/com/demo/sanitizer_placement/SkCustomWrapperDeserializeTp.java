package com.demo.sanitizer_placement;
import javax.servlet.http.*;
public class SkCustomWrapperDeserializeTp {
  private static String companySanitize(String v) { return v.replace('pickle', ""); }
  public void handle(HttpServletRequest req) throws Exception {
    String blob = companySanitize(new String(req.getInputStream().readAllBytes()));
    new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(blob.getBytes())).readObject();
  }
}
