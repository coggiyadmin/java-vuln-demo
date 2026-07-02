package com.demo.sanitizer_placement;
import com.mongodb.client.*;
import javax.servlet.http.*;
public class SkCustomWrapperNosqlTp {
  private static String companySanitize(String v) { return v.replace("$", ""); }
  public void handle(HttpServletRequest req, MongoCollection<?> col) {
    String user = companySanitize(req.getParameter("user"));
    col.find(new org.bson.Document("user", user));
  }
}
