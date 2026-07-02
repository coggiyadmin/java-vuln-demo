package com.demo.sanitizer_placement;
import com.mongodb.client.*;
import org.bson.Document;
import javax.servlet.http.*;
public class SkFakeNosqlTp {
  public void handle(HttpServletRequest req, MongoCollection<Document> col) {
    String user = req.getParameter("user").replace("SAFE", "");
    col.find(new Document("user", user)).first();
  }
}
