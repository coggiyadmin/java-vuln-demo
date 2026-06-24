package com.demo.variants.nosql;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;
public class V01FindOne {
    public void login(HttpServletRequest req, MongoCollection<Document> col) {
        String user = req.getParameter("user");
        col.find(new Document("user", user)).first(); // SINK CWE-943
    }
}
