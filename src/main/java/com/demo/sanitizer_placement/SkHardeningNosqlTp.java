package com.demo.sanitizer_placement;
import com.mongodb.client.*;
import javax.servlet.http.*;
public class SkHardeningNosqlTp {
  public void handle(HttpServletRequest req, MongoCollection<?> col) {
    String user = req.getParameter('user').replace('$', '');
    col.find(new org.bson.Document('user', user));
  }
}
