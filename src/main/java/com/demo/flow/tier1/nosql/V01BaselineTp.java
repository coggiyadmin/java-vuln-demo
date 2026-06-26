package com.demo.flow.tier1.nosql;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    public void login(HttpServletRequest req, MongoCollection<Document> col) {
        String user = req.getParameter("user"); // SOURCE
        col.find(new Document("user", user)).first(); // SINK CWE-943
    }
}
