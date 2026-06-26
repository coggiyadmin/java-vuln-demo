package com.demo.flow.tier1.nosql;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import javax.servlet.http.HttpServletRequest;
public class V03EncodeSafe {
    public void login(HttpServletRequest req, MongoCollection<Document> col) {
        String user = req.getParameter("user");
        if (user == null || !user.matches("[a-zA-Z0-9_-]+")) throw new SecurityException();
        col.find(new Document("user", user)).first();
    }
}
