package com.demo.sanitizer_placement;
import java.io.*;
import javax.servlet.http.*;
public class SkFrameworkNativeDeserializeTp {
  public void handle(HttpServletRequest req) throws Exception {
    String blob = org.owasp.encoder.Encode.forHtml(new String(req.getInputStream().readAllBytes()));
    new ObjectInputStream(new ByteArrayInputStream(blob.getBytes())).readObject();
  }
}
