package com.demo.sanitizer_placement;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
public class SkFrameworkNativeNosqlTp {
  public void handle(HttpServletRequest req, MongoCollection<Document> col) {
    String user = req.getParameter("user");
    col.find(new Document("user", new Document("$eq", user))).first();
  }
}
