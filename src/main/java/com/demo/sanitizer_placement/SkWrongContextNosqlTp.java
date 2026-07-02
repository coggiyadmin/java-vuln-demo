package com.demo.sanitizer_placement;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
public class SkWrongContextNosqlTp {
  public void handle(HttpServletRequest req, MongoCollection<Document> col) {
    String user = req.getParameter("user").replace("<", "&lt;");
    col.find(new Document("user", user)).first();
  }
}
