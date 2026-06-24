package com.demo.variants.sqli;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;
public class V04MongooseFind {
    public void find(HttpServletRequest req, MongoCollection<Document> col) {
        String user = req.getParameter("user");
        col.find(new Document("user", user)).first(); // SINK CWE-943
    }
}
